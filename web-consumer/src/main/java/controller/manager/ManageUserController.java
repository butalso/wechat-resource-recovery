package controller.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Order;
import entity.*;
import exception.AddressNonExistsException;
import exception.UserNameExistException;
import exception.UserNonExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.OrderService;
import service.UserActivationService;
import service.UserService;
import service.WalletService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manager/user")
@Api(tags = "管理员管理用户信息")
public class ManageUserController {
    @Reference
    UserService userService;
    @Reference
    OrderService orderService;
    @Reference
    UserActivationService userActivationService;
    @Reference
    WalletService walletService;

    @RequestMapping(value = "/{userKind}", method = RequestMethod.GET)
    @ApiOperation(value = "获取某类所有用户基本信息")
    public ModelAndView getAllUsers(@PathVariable("userKind") Integer userKind) {
        ModelAndView mav = new ModelAndView("manager/view");
        List<? extends User> users = userService.getAllUsers(userKind);
        switch (userKind) {
            case 0: mav.addObject("users", (List<Customer>) users);
                    break;
            case 1: mav.addObject("users", (List<Collector>) users);
                    break;
            default: mav.addObject("users", (List<Company>) users);
        }
        return mav;
    }

    @RequestMapping(value = "/{userKind}/create_time", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户创建日期获取某类所有用户基本信息")
    public List<User> getUsersByCreateTime(@PathVariable("userKind") Integer userKind,
                               @RequestParam("fromTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date fromTime,
                               @RequestParam("endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<? extends User> users = userService.getAllUsers(userKind);
        List<User> result = new ArrayList<>();
        for (User user : users) {
            Date createTime = user.getCreateTime();
            if (createTime.after(fromTime) && createTime.before(endTime)) {
                result.add(user);
            }
        }
        return result;
    }

    @RequestMapping(value = "/{userKind}/experience", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户经验值获取某类所有用户基本信息")
    public List<User> getUsersByExperience(@PathVariable("userKind") Integer userKind,
                               @RequestParam("from") Integer from,
                               @RequestParam("end") Integer end) {
        if (userKind != 0 && userKind != 1) {
            return null;
        }
        List<? extends User> users = userService.getAllUsers(userKind);
        List<User> result = new ArrayList<>();
        for (User user : users) {
            Integer experience = ((ECPUser) user).getExperience();
            if (experience >= from && experience <= end) {
                result.add(user);
            }
        }
        return result;
    }

    @RequestMapping(value = "/{userKind}/credit", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户诚信值获取某类所有用户基本信息")
    public List<User> getUsersByCredit(@PathVariable("userKind") Integer userKind,
                               @RequestParam("from") Integer from,
                               @RequestParam("end") Integer end) {
        if (userKind != 0 && userKind != 1) {
            return null;
        }
        List<? extends User> users = userService.getAllUsers(userKind);
        List<User> result = new ArrayList<>();
        for (User user : users) {
            Integer credit = ((ECPUser) user).getCredit();
            if (credit >= from && credit <= end) {
                result.add(user);
            }
        }
        return result;
    }

    @RequestMapping(value = "/{userKind}/{userName}", method = RequestMethod.GET)
    @ApiOperation(value = "获取某个用户详细信息,包括订单，钱包交易记录，用户活跃度")
    public ModelAndView getUser(@PathVariable("userKind") Integer userKind,
                                @PathVariable("userName") String userName) {
        ModelAndView mav = null;
        User user = userService.getUserDetails(userName, userKind);
        List<WalletRecord> walletRecords = null;
        List<Order> orders = orderService.getOrders(userName, userKind);
        List<UserActivation> userActivations = userActivationService.getUserActivations(new User(user.getId(), userName, userKind));

        switch (userKind) {
            case 0: mav = new ModelAndView("manager/customerDetail");
                    mav.addObject("user", (Customer) user);
                    mav.addObject("walletRecords", walletService.getWalletRecord(((Customer) user).getWallet().getId()));
                    break;
            case 1: mav = new ModelAndView("manager/collectorDetail");
                    mav.addObject("user", (Collector) user);
                    mav.addObject("walletRecords", walletService.getWalletRecord(((Collector) user).getWallet().getId()));
                    break;
            case 2: mav = new ModelAndView("manager/companyDetail");
                    mav.addObject("user", (Company) user);
                    mav.addObject("walletRecords", walletService.getWalletRecord(((Company) user).getWallet().getId()));
                    break;
        }

        mav.addObject("orders", orders);
        mav.addObject("userActivations", userActivations);
        return mav;
    }

    @RequestMapping(value = "/{userKind}/{userName}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户")
    public ResponseEntity<String> deleteUser(@PathVariable("userKind") Integer userKind,
                           @PathVariable("userName") String userName) {
        try {
            userService.delUser(userName, userKind);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("删除成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/0/{userName}", method = RequestMethod.POST)
    @ApiOperation(value = "修改业主信息,name不变", notes = "属性包括name,password，gender，phone，credit，" +
            "experience，point，address ")
    public ResponseEntity<String> updateCustomer(@PathVariable("userName") String userName,
                               @RequestBody Customer customer) {
        return updateUser(customer, userName);
    }

    @RequestMapping(value = "/1/{userName}", method = RequestMethod.POST)
    @ApiOperation(value = "修改回收员，name不变", notes = "属性包括name，companyName，password，IDCardNo，" +
            "gender，phone，credit，point，experience，address")
    public ResponseEntity<String> updateCollector(@PathVariable("userName") String userName,
                                @RequestBody Collector collector) {
        return updateUser(collector, userName);
    }

    @RequestMapping(value = "/2/{userName}", method = RequestMethod.POST)
    @ApiOperation(value = "修改企业信息,name不变", notes = "属性包括name, password, phone, address")
    public ResponseEntity<String> updateCompany(@PathVariable("userName") String userName,
                              @RequestBody Company company) {
        return updateUser(company, userName);
    }

    private ResponseEntity<String> updateUser(User user, String userName) {
        User user1 = userService.getUserBasic(userName, user.getUserKind());
        if (user1 == null) {
            return new ResponseEntity<String>("用户不存在", HttpStatus.NOT_FOUND);
        }
        user.setId(user1.getId());
        user.setImageUrl(user1.getImageUrl());
        try {
            userService.updateUser(user);
        } catch (UserNonExistsException | AddressNonExistsException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<String>("修改成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/0", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8",
            produces = "text/plain;charset=UTF-8")
    @ApiOperation(value = "添加业主", notes = "属性包括name, password," +
            "gender, phone, address")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        try {
            userService.addUser(customer);
        } catch (UserNameExistException |AddressNonExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("添加成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/1", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8",
            produces = "text/plain;charset=UTF-8")
    @ApiOperation(value = "添加回收员", notes = "属性包括name, companyName, password, IDCardNo," +
            "gender, phone, address")
    public ResponseEntity<String> addCollector(@RequestBody Collector collector) {
        try {
            userService.addUser(collector);
        } catch (UserNameExistException |AddressNonExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("添加成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/2", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8",
            produces = "text/plain;charset=UTF-8")
    @ApiOperation(value = "添加企业", notes = "属性包括name, password, phone, address")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        try {
            userService.addUser(company);
        } catch (UserNameExistException |AddressNonExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("添加成功", HttpStatus.CREATED);
    }

}
