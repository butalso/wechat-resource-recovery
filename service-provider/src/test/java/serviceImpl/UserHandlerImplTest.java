package serviceImpl;

import entity.Collector;
import entity.Company;
import entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserHandler;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class UserHandlerImplTest {
    @Autowired
    UserHandler userHandler;

    Customer customer;
    Collector collector;
    Company company;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("杰克", "123456",
                "15325678899", "jack", "M", 2);

        collector = new Collector("铁柱", "123456",
                "13425809981", "tiezhu", "440882199808092213",
                "M", 2);

        company = new Company("回收哥", "123456",
                "15824568897", "440882", "西湖大道7号");

    }

    @Test
    public void addUser() {
        userHandler.addUser(customer);
        userHandler.addUser(collector);
        userHandler.addUser(company);
    }

    @Test
    public void delUser() {
        userHandler.delUser("jack", 0);
        userHandler.delUser("tiezhu", 1);
        userHandler.delUser("回收哥", 2);
    }

    @Test
    public void updateUser() {
        customer.setPassword("789");
        collector.setPassword("789");
        company.setPassword("789");
        userHandler.updateUser(customer);
        userHandler.updateUser(collector);
        userHandler.updateUser(company);
    }

    @Test
    public void getUser() {
        System.out.println("customer: " + userHandler.getUser("jack", 0));
        System.out.println("collector: " + userHandler.getUser("tiezhu", 1));
        System.out.println("company: " + userHandler.getUser("回收哥", 2));
    }
}