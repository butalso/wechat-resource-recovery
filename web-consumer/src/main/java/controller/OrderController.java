package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Order;
import entity.Garbage;
import entity.OrderDetail;
import entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.OrderHandler;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
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
    @ApiOperation(value = "返回与用户相关订单集合")
    public List<Order> getOrders(@ApiIgnore @ModelAttribute("user") User user) {
        List<Order> result = orderHandler.getOrders(user.getId(), user.getUserKind());
        return result;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "给回收员返回回收范围内用户新建订单集合")
    public List<Order> getNewOrder(@ApiIgnore @ModelAttribute("user") User user) {
        return orderHandler.getNewOrders(user.getId());
    }

    @RequestMapping(value = "/receive", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "回收员确定接受订单编号为orderId的订单")
    public ResponseEntity<String> receiveOrder(@ApiIgnore @ModelAttribute("user") User user,
                                    @RequestParam("orderId") Integer orderId) {
        try {
            orderHandler.receiveOrder(user.getId(), orderId);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("接单成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "用户创建订单")
    public ResponseEntity<String> createOrder(@ApiIgnore @ModelAttribute("user") User user,
                              @RequestBody OrderDetail[] orderDetails) {
        Map<String, Double> garbages = new HashMap<>();
        for (OrderDetail orderDetail : orderDetails) {
            garbages.put(orderDetail.getName(), orderDetail.getWeight());
        }

        try {
            orderHandler.createOrder(user.getId(), garbages);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("创建成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "回收员修正某订单的具体信息")
    public ResponseEntity<String> updateOrder(@RequestBody OrderDetail[] orderDetails) {
        // TODO 向业主发送消息确认
        try {
            Map<Integer, Map<String, String>> infos = new HashMap<>();
            for (OrderDetail orderDetail : orderDetails) {
                Map<String, String> map = infos.get(orderDetail.getOrderId());
                if (map == null) {
                    map = new HashMap<>();
                    infos.put(orderDetail.getOrderId(), map);
                }
                map.put(orderDetail.getName(), String.valueOf(orderDetail.getWeight()));
            }
            for (Map.Entry<Integer, Map<String, String>> info : infos.entrySet()) {
                orderHandler.updateOrderDetails(info.getKey(), info.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("修改成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8"
    )
    @ResponseBody
    @ApiOperation(value = "用户确认订单完成，并给该次交易评分")
    public ResponseEntity<String> confirmOrder(@ApiIgnore @ModelAttribute("user") User user,
                                       @RequestParam("orderId") Integer orderId,
                                       @RequestParam("grade") Integer grade ) {
        try {
            orderHandler.confirmOrderFinish(user, orderId, grade);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("确认成功", HttpStatus.CREATED);
    }

}
