package util;

import dto.Order;
import entity.OrderDetail;
import entity.OrderItem;

import java.util.List;

/**
 * 将订单数据装配成Order对象
 */
public class OrderUtil {

    public static Order orderInstance(OrderItem orderItem, List<OrderDetail> orderDetails) {
        // TODO
        return new Order();
    }
}
