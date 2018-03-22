package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Order;
import entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.OrderService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
@SessionAttributes("user")
@Api(tags = "订单信息控制")
public class OrderController {

    @Reference
    OrderService orderService;

    @RequestMapping(value = "/info", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "返回与用户相关订单集合和订单页面")
    public ModelAndView getOrders(@ApiIgnore @ModelAttribute("user") User user) {
        ModelAndView mav = new ModelAndView("user/order_list");
        List<Order> orders = orderService.getOrders(user.getName(), user.getUserKind());
        mav.addObject("orders", orders);
        mav.addObject("userKind", user.getUserKind());
        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8",
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "用户创建订单", notes = "格式如下：{\n" +
            "  \"orderDetails\": [\n" +
            "    {\n" +
            "      \"name\": \"废报纸\",\n" +
            "      \"weight\": 10\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"废纸箱\",\n" +
            "      \"weight\": 10\n" +
            "    }\n" +
            "  ],\n" +
            "  \"orderItem\": {\n" +
            "    \"address\": {\n" +
            "      \"area\": \"江宁区\",\n" +
            "      \"city\": \"南京市\",\n" +
            "      \"detail\": \"佛城西路八号\",\n" +
            "      \"province\": \"江苏省\"\n" +
            "    },\n" +
            "    \"collectEndTime\": \"2018-03-18 09:07:47\",\n" +
            "    \"collectFromTime\": \"2018-03-18 09:07:47\"\n" +
            "  }\n" +
            "}")
    public ResponseEntity<String> createOrder(@RequestBody Order order,
                                              @ApiIgnore @ModelAttribute("user") User user) {
        order.getOrderItem().setCustomerName(user.getName());
        try {
            orderService.addOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("创建成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/order_details", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "用户修正订单详情")
    public ResponseEntity<String> updateOrder(@ApiIgnore @ModelAttribute("user") User user,
                                              @RequestBody Order order) {
        try {
            orderService.updateOrderDetails(order.getOrderItem().getId(), order.getOrderDetails());
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("修改成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/new_orders", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "给回收员返回回收范围内用户新建订单集合")
    public ModelAndView getNewOrder(@ApiIgnore @ModelAttribute("user") User user) {
        if (user.getUserKind() != 1) {
            /*非回收员用户，重定向到个人订单*/
            return new ModelAndView("redirect:/order");
        }

        ModelAndView mav = new ModelAndView("user/collector_newOrder");
        mav.addObject("orders", orderService.getNewOrders(user.getName()));
        return mav;
    }

    @RequestMapping(value = "/{orderItemId}", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获取某订单详情")
    public Order getOrder(@PathVariable("orderItemId") Integer orderItemId) {
        return orderService.getOrder(orderItemId);
    }

    @RequestMapping(value = "/{orderItemId}/receive", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "回收员确定接受订单编号为orderItemId的订单")
    public ResponseEntity<String> receiveOrder(@ApiIgnore @ModelAttribute("user") User user,
                                    @PathVariable("orderItemId") Integer orderItemId) {
        if (user.getUserKind() != 1) {
            return new ResponseEntity<>("用户类型为非回收员", HttpStatus.FORBIDDEN);
        }
        try {
            orderService.receiveOrder(user.getName(), orderItemId);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("接单成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{orderItemId}/confirm_receive", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8"
    )
    @ResponseBody
    @ApiOperation(value = "回收员确认订单完成，并使公司向业主转账")
    public ResponseEntity<String> confirmOrderReceive(@ApiIgnore @ModelAttribute("user") User user,
                                       @PathVariable("orderItemId") Integer orderItemId) {
        try {
            orderService.confirmOrderReceive(user.getName(), orderItemId);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("确认成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{orderItemId}/grade", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "业主，回收员对订单评分，获取经验值，诚信值，积分值")
    public ResponseEntity<String> gradeOrder(@ApiIgnore @ModelAttribute("user") User user,
                                             @RequestParam("orderItemId") Integer orderItemId,
                                             @RequestParam("grade") Integer grade) {
        try {
            orderService.gradeOrder(orderItemId, user.getName(), user.getUserKind(), grade);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("评分成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/confirm_finish", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8",
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "企业确认订单完成，并向回收员发放提成")
    public ResponseEntity<String> confirmOrderFinish(@ApiIgnore @ModelAttribute("user") User user,
                                                     @RequestParam("payPassword") String payPass,
                                                     @RequestParam("orderItemIds") List<Integer> orderItemIds) {
        try {
            for (Integer orderItemId : orderItemIds) {
                orderService.confirmOrderFinish(user.getName(), orderItemId, payPass);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 异常处理
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("确认成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/details"}, method = RequestMethod.GET)
    @ApiOperation(value = "获取订单详情页面")
    public String orderDetails() {
        return "user/customer_order_details";
    }

}
