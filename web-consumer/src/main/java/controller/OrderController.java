package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Order;
import entity.User;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.OrderHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/order")
@SessionAttributes("user")
@Api(tags = "订单信息控制")
public class OrderController {

    @Reference
    OrderHandler orderHandler;

    @RequestMapping(value = "/info", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Order> getOrders(@ModelAttribute("user") User user) {
        List<Order> result = orderHandler.getOrders(user.getId(), user.getUserKind());
        return result;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getNewOrder(@ModelAttribute("user") User user) {
        return orderHandler.getNewOrders(user.getId());
    }

    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    @ResponseBody
    public String receiveOrder(@ModelAttribute("user") User user,
                                    @RequestParam("orderId") Integer orderId) {
        try {
            orderHandler.receiveOrder(user.getId(), orderId);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return "接单失败";
        }
        return "接单成功";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createOrder(@ModelAttribute("user") User user,
                              @RequestBody Map<String, Double> garbages) {
        try {
            orderHandler.createOrder(user.getId(), garbages);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return "创建失败";
        }
        return "创建成功";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateOrder(@RequestBody Map info) {
        // TODO 向业主发送消息确认
        try {
            Integer orderId = (Integer) info.get("orderId");
            Map<String, String> garbages = (HashMap<String, String>) info.get("garbages");
            orderHandler.updateOrderDetails(orderId , garbages);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return "修改失败";
        }
        return "修改成功";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    @ResponseBody
    public String confirmOrder(@ModelAttribute("user") User user,
                              @RequestBody Map info) {
        try {
            orderHandler.confirmOrderFinish(user, (Integer) info.get("orderId"),
                    (Integer) info.get("grade"));
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return "确认失败";
        }
        return "确认成功";
    }

}
