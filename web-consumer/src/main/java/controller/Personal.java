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
@RequestMapping(value = "/personal/{userKind}/{nickName}")
@SessionAttributes("user")
public class Personal {
    @Reference
    UserHandler userHandler;
    @Reference
    AccountHandler accountHandler;

    @RequestMapping(value = "/info", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User getUserDetail(@ModelAttribute("user") User user) {
        return user;
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateUserDetail(@ModelAttribute("user") User user,
                                 @RequestBody User newUser) {
        newUser.setId(user.getId());
        if (user.getUserKind() == 0) {
            System.out.println((Customer) newUser);
        } else if (user.getUserKind() == 1) {
            System.out.println((Controller) newUser);
        }
        userHandler.updateUser(user);
        return null;
    }

    @RequestMapping(value = "/orders",
            method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Order> getOrders(@ModelAttribute("user") User user) {


        return null;
    }



}
