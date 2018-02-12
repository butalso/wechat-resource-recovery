package serviceImpl;

import dto.Order;
import entity.Collector;
import entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.OrderHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class OrderHandlerImplTest {

    @Autowired
    OrderHandler orderHandler;

    @Test
    public void getOrders() {
        List<Order> orders;
        orders = orderHandler.getOrders(1, 0);
        System.out.println(orders);
    }

    @Test
    public void getNewOrders() {
        System.out.println(orderHandler.getNewOrders(1));
    }


    @Test
    public void createOrder() {
        Map<String, Double> map = new HashMap<>();
        map.put("废书纸", 2.5);
        map.put("废纸箱", 3.5);
        map.put("废报纸", 4.5);
        orderHandler.createOrder(1, map);
    }

    @Test
    public void updateOrderDetails() {
        Map<String, Double> map = new HashMap<>();
        map.put("废书纸", 12.5);
        map.put("废纸箱", 13.5);
        orderHandler.updateOrderDetails(10, map);
    }

    @Test
    public void receiveOrder() {
        orderHandler.receiveOrder(1, 9);
    }

    @Test
    public void confirmOrderFinish() {
        Customer customer = new Customer();
        customer.setId(1);
        orderHandler.confirmOrderFinish(customer, 9, 3);
        customer.setId(2);
        orderHandler.confirmOrderFinish(customer, 10, 3);

        Collector collector = new Collector();
        collector.setId(1);
        orderHandler.confirmOrderFinish(collector, 9, 5);
        collector.setId(2);
        orderHandler.confirmOrderFinish(collector, 10, 5);
    }
}