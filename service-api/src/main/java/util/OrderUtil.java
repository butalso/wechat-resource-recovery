package util;

import dto.Order;
import entity.OrderDetail;
import entity.OrderItem;

import java.util.List;

/**
 * 将订单数据装配成Order对象
 */
public class OrderUtil {

    /**
     * 计算订单价值
     * @param order
     * @return
     */
    public static Double calculateOrderValue(Order order) {
        List<OrderDetail> orderDetails = order.getOrderDetails();
        Double result = 0d;

        for (OrderDetail orderDetail : orderDetails) {
            result += orderDetail.getPrice() * orderDetail.getWeight();
        }
        return (double) Math.round(result * 100) / 100;
    }

    /**
     * 计算业主订单获取的积分值
     * @param order
     * @return
     */
    public static Integer calculateOrderPointToCustomer(Order order, int grade) {
        return (int) (calculateOrderValue(order) * 0.5);
    }

    /**
     * 计算业主订单获取的经验值
     * @param order
     * @return
     */
    public static Integer calculateOrderExperienceToCustomer(Order order, int grade) {
        return (int) (calculateOrderValue(order) * 0.8);
    }

    /**
     * 计算业主订单获取的信誉值
     * @param order
     * @return
     */
    public static Integer calculateOrderCreditToCustomer(Order order, int grade) {
        return (int) (calculateOrderValue(order) * 0.5);
    }

    /**
     * 计算回收员订单获取的积分值
     * @param order
     * @return
     */
    public static Integer calculateOrderPointToCollector(Order order, int grade) {
        return (int) (calculateOrderValue(order) * 0.4);
    }

    /**
     * 计算回收员订单获取的经验值
     * @param order
     * @return
     */
    public static Integer calculateOrderExperienceToCollector(Order order, int grade) {
        return (int) (calculateOrderValue(order) * 0.7);
    }

    /**
     * 计算订单回收员获取的信誉值
     * @param order
     * @return
     */
    public static Integer calculateOrderCreditToCollector(Order order, int grade) {
        return (int) (calculateOrderValue(order) * 0.5);
    }

}
