package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.*;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("user")
@Api(tags = "用户信息控制")
public class UserController {
    @Reference
    UserService userService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ApiOperation(value = "返回用户个人中心页面")
    public ModelAndView getUserDetail(@ApiIgnore @ModelAttribute("user") User user) {
        ModelAndView mav = null;
        switch (user.getUserKind()) {
            case 0:
                mav = new ModelAndView("user/customer");
                break;
            case 1:
                mav = new ModelAndView("user/collector");
                break;
            case 2:
                mav = new ModelAndView("user/company");
                break;
        }
        User useDetails = userService.getUserDetails(user.getName(), user.getUserKind());
        useDetails.setPassword(null);
        mav.addObject("userDetails", useDetails);
        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST,
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


    @RequestMapping(value = "/password", method = RequestMethod.POST,
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

    @RequestMapping(value = {"/order"}, method = RequestMethod.GET)
    @ApiOperation(value = "获取用户订单详情页面")
    public String customerOrder() {
        return "user/customer_order_list";
    }

}
