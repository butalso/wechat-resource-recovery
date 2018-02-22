package dao;

import dto.Order;
import entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

// junit 运行时加载spring-ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class OrderDaoTest {
    @Autowired
    OrderDao orderDao;

    @Test
    public void createOrder() {
        OrderItem orderItem = new OrderItem();
        orderDao.createOrder(1, orderItem);
        orderDao.createOrder(1, orderItem);
        orderDao.createOrder(2, orderItem);

        System.out.println(orderItem.getId());
    }

    @Test
    public void addOrderDetail() {
//        orderDao.addOrderDetail(1, "废书纸", 2.5);
//        orderDao.addOrderDetail(1, "废报纸", 2.2);
//        orderDao.addOrderDetail(1, "废纸箱", 2.1);
    }

    @Test
    public void updateOrderDetail() {
        orderDao.updateOrderDetail(1, "废书纸", 3.2);
    }

    @Test
    public void delOrder() {
        orderDao.delOrder(2);
    }

    @Test
    public void delOrderDetails() {
        orderDao.delOrderDetails(3);
    }

    @Test
    public void customerOrderItems() {
        System.out.println(orderDao.customerOrderItems(1));
    }

    @Test
    public void collectorOrderItems() {
        System.out.println(orderDao.collectorOrderItems(2));
    }

    @Test
    public void companyOrderItems() {
        System.out.println(orderDao.companyOrderItems(2));
    }

    @Test
    public void getOrderDetails() {
        System.out.println(orderDao.getOrderDetails(10));
    }

    @Test
    public void getOrderItem() {
        OrderItem orderItem = orderDao.getOrderItem(1);
        System.out.println(orderItem);
    }

    @Test
    public void updateOrder() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(1);
        orderItem.setState(2);
        orderItem.setCollectorId(1);
        orderItem.setCompanyId(2);
        orderItem.setFinishTime(new Date());
        orderItem.setUserGrade(3);
        orderItem.setCollectorGrade(5);

    }

    @Test
    public void getNewOrdersId() {
        System.out.println(orderDao.getNewOrdersId(1));
    }

    @Test
    public void finishOrder() {
        orderDao.finishOrder(5);
    }
}