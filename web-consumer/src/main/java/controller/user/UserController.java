package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Order;
import entity.*;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.OrderService;
import service.UserService;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("user")
@Api(tags = "用户信息控制")
public class UserController {
    @Reference
    UserService userService;
    @Reference
    OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "返回用户个人中心页面")
    public ModelAndView getUserDetail(@ApiIgnore @ModelAttribute("user") User user) {
        ModelAndView mav = null;
        User useDetails = userService.getUserDetails(user.getName(), user.getUserKind());
        switch (user.getUserKind()) {
            case 0:
                mav = new ModelAndView("user/customer");
                mav.addObject("userDetails", (Customer) useDetails);
                break;
            case 1:
                mav = new ModelAndView("user/collector");
                mav.addObject("userDetails", (Collector) useDetails);
                break;
            case 2:
                mav = new ModelAndView("user/company");
                mav.addObject("userDetails", (Company) useDetails);
                break;
        }
        useDetails.setPassword(null);

        return mav;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT,
            consumes = "application/json;charset=UTF-8",
            produces = "text/plain;charset=UTF-8")
    @ApiOperation(value = "业主修改头像，性别，电话，地址信息")
    public ResponseEntity<String> updateUserDetail(@RequestBody Customer customer,
                                                   @ApiIgnore @ModelAttribute("user") User user) {
        Customer oldCustomer = (Customer) userService.getUserDetails(user.getName(), user.getUserKind());
        resetCustomer(oldCustomer, customer);
        userService.updateUser(oldCustomer);
        return new ResponseEntity<>("修改成功", HttpStatus.CREATED);
    }

    private void resetCustomer(Customer oldCustomer, Customer newCustomer) {
        oldCustomer.setPhone(newCustomer.getPhone());
        oldCustomer.setGender(newCustomer.getGender());
        oldCustomer.setAddress(newCustomer.getAddress());
    }

    @RequestMapping(value = "/password", method = RequestMethod.PUT,
            consumes = "application/json;charset=UTF-8")
    public ResponseEntity<String> changePassword(@ApiIgnore @ModelAttribute("user") User user,
                                                 @RequestParam("oldPass") String oldPass,
                                                 @RequestParam("newPass") String newPass) {

        User user1 = userService.getUserDetails(user.getName(), user.getUserKind());
        if (user1 != null && !user1.getPassword().equals(oldPass)) {
            return new ResponseEntity<String>("旧密码错误", HttpStatus.FORBIDDEN);
        }
        user1.setPassword(newPass);
        userService.updateUser(user1);
        return new ResponseEntity<>("密码修改成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/details"}, method = RequestMethod.GET)
    @ApiOperation(value = "获取用户详情页")
    public ModelAndView userHome(@ApiIgnore @ModelAttribute("user") User user) {
        ModelAndView mav = null;
        User useDetails = userService.getUserDetails(user.getName(), user.getUserKind());
        mav = new ModelAndView("user/customer_details");
        mav.addObject("userDetails", (Customer) useDetails);
        useDetails.setPassword(null);

        return mav;
    }

    @RequestMapping(value = "/company/collectors", method = RequestMethod.GET)
    @ApiOperation(value = "返回企业下所有业主页面")
    public ModelAndView getCollectors(@ApiIgnore @ModelAttribute("user") User user) {
        ModelAndView mav = new ModelAndView("user/collectors");
        if (user.getUserKind() != 2) {
            /*非企业用户*/
            return null;
        }
        List<Collector> allCollectors = (List<Collector>) userService.getAllUsers(1);
        List<Collector> collectors = new ArrayList<>();
        for (Collector collector : allCollectors) {
            collector = (Collector)userService.getUserDetails(collector.getName(), 1);
            if ((collector.getCompanyName().equals(user.getName()))) {
                collectors.add(collector);
            }
        }

        mav.addObject("collectors", collectors);
        return mav;
    }

    @RequestMapping(value = "/collectors/{userName}/orders", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "返回企业下某回收员相关订单集合和订单页面")
    public ModelAndView getCollectorOrders(@PathVariable("userName") String userName) {
        ModelAndView mav = new ModelAndView("user/order_list");
        List<Order> orders = orderService.getOrders(userName, 1);
        mav.addObject("orders", orders);
        mav.addObject("userKind", 2);
        return mav;
    }
}
