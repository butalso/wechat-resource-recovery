package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Account;
import entity.Customer;
import entity.User;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AccountHandler;
import service.UserHandler;

import java.util.List;

@Controller
@RequestMapping(value = "/{userKind}/{nickName}/personal")
@SessionAttributes("user")
public class Personal {
    @Reference
    UserHandler userHandler;
    @Reference
    AccountHandler accountHandler;

    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User getUserDetail(@ModelAttribute("user") User user) {
        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateUserDetail(@ModelAttribute("user") User user,
                                 @RequestBody User newUser) {
        newUser.setId(user.getId());
        System.out.println(newUser);
        userHandler.updateUser(newUser);
        return null;
    }

    @RequestMapping(value = "/orders",
            method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Order> getOrders(@ModelAttribute("user") User user) {

        return null;
    }

}
