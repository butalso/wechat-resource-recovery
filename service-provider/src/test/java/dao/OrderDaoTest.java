package dao;

import dto.Address;
import entity.OrderDetail;
import entity.OrderItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

// junit 运行时加载spring-ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    OrderItem orderItem;
    List<OrderDetail> orderDetails;

    @Before
    public void setUp() throws Exception {
        orderItem = new OrderItem("约翰",
                new Address("江苏省", "南京市", "江宁区", "佛城西路八号"),
                new Date(), new Date());

        orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetail("废报纸", 10.2));
        orderDetails.add(new OrderDetail("废纸箱", 10.3));
    }

    @Test
    public void addOrderItem() {
        orderDao.addOrderItem(orderItem);
        System.out.println(orderItem.getId());
    }

    @Test
    public void addOrderDetails() {
        orderDao.addOrderDetails(1, orderDetails);
    }

    @Test
    public void deleteOrderItem() {
        System.out.println(orderDao.deleteOrderItem(6, "乔治"));
        System.out.println(orderDao.deleteOrderItem(6, "约翰"));
        System.out.println(orderDao.deleteOrderItem(5, "乔治"));
        System.out.println(orderDao.deleteOrderItem(5, "约翰"));
    }

    @Test
    public void deleteOrderDetails() {
        orderDao.deleteOrderDetails(1);
    }


    @Test
    public void getCustomerOrderItems() {
        System.out.println(orderDao.getCustomerOrderItems("约翰"));
    }

    @Test
    public void getCollectorOrderItems() {
        System.out.println(orderDao.getCollectorOrderItems("恐怖利刃"));
    }

    @Test
    public void getCompanyOrderItems() {
        System.out.println(orderDao.getCompanyOrderItems("回收哥"));
    }

    @Test
    public void getOrderDetails() {
        System.out.println(orderDao.getOrderDetails(8));
    }

    @Test
    public void getNewOrderItems() {
        System.out.println(orderDao.getNewOrderItems("恐怖利刃"));
    }

    @Test
    public void receiveOrder() {
        System.out.println(orderDao.receiveOrder(7, "恐怖利刃"));
    }

    @Test
    public void collectorConfirmReceive() {
//        orderDao.collectorConfirmReceive(2, "www");
        orderDao.collectorConfirmReceive(5, "恐怖利刃");
    }

    @Test
    public void customerGradeOrder() {
        orderDao.customerGradeOrder(2, 3, "乔治");
        orderDao.customerGradeOrder(2, 3, "约翰");
    }

    @Test
    public void collectorGradeOrder() {
        orderDao.collectorGradeOrder(2, 4, "恐怖");
        orderDao.collectorGradeOrder(2, 4, "恐怖利刃");
    }

    @Test
    public void finishOrder() {
        orderDao.finishOrder(2, "回收");
        orderDao.finishOrder(2, "回收哥");
    }

    @Test
    public void getOrderItem() {
        System.out.println(orderDao.getOrderItem(7));
    }
}