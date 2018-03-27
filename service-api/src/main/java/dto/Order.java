package dto;

import entity.OrderDetail;
import entity.OrderItem;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Order implements Serializable {

    private OrderItem orderItem;
    /* 订单详情，废品到重量的映射 */
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(OrderItem orderItem, List<OrderDetail> orderDetails) {
        this.orderItem = orderItem;
        this.orderDetails = orderDetails;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItem=" + orderItem +
                ", orderDetails=" + orderDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderItem, order.orderItem) &&
                Objects.equals(orderDetails, order.orderDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItem, orderDetails);
    }
}
