package controller;

import dto.Order;
import entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
@SessionAttributes("user")
public class OrderController {

//    @RequestMapping(value = "/orders",
//            method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public List<Order> getOrders(@ModelAttribute("user") User user) {
//
//        return null;
//    }
}
