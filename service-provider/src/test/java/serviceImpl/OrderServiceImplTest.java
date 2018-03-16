package serviceImpl;

import dto.Address;
import dto.Order;
import entity.OrderDetail;
import entity.OrderItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class OrderServiceImplTest {
    @Autowired
    OrderService orderService;

    List<OrderDetail> orderDetails;
    OrderItem orderItem;
    Order order;

    @Before
    public void setUp() throws Exception {
        orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetail("废书纸", 5));
        orderDetails.add(new OrderDetail("废报纸", 6));
        orderDetails.add(new OrderDetail("废纸箱", 7));

        orderItem = new OrderItem("熊大", new Address("江苏省", "南京市", "江宁区", "江南青年城"),
                new Date(), new Date());

        order = new Order(orderItem, orderDetails);

    }

    @Test
    public void addOrder() {
        orderService.addOrder(order);
    }

    @Test
    public void getOrders() {
        System.out.println(orderService.getOrders("熊大", 0));
//        System.out.println(orderService.getOrders("恐怖利刃", 1));
//        System.out.println(orderService.getOrders("回收哥", 2));
    }

    @Test
    public void getNewOrders() {
        System.out.println(orderService.getNewOrders("恐怖利刃"));
    }

    @Test
    public void delUnfinishOrder() {
//        orderService.delUnfinishOrder("熊大", 8);
        orderService.delUnfinishOrder("熊大", 9);
    }

    @Test
    public void receiveOrder() {
        orderService.receiveOrder("恐怖利刃", 8);
    }

    @Test
    public void confirmOrderReceive() {
        orderService.confirmOrderReceive("恐怖利刃", 8);
    }

    @Test
    public void confirmOrderFinish() {
        orderService.confirmOrderFinish("回收哥", 8, "123456");
    }

    @Test
    public void gradeOrder() {
        orderService.gradeOrder(8, "熊大", 0, 5);
        orderService.gradeOrder(8, "恐怖利刃", 1, 5);
    }
}