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
import service.AccountHandler;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class AccountHandlerImplTest {

    @Autowired
    AccountHandler accountHandler;

    Customer customer;
    Collector collector;
    Company company;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("杰克", "123456",
                "15325678899", "jack", "M", 2);

        collector = new Collector("铁柱", "123456",
                "13425809981", "tiezhu", "回收哥", "440882199808092213",
                "M", 2);

        company = new Company("回收哥", "123456",
                "15824568897", "440882", "西湖大道7号");

    }

    @Test
    public void addAccount() {
        collector.setId(3);
        accountHandler.addAccount(collector, "问月", "123");
    }

    @Test
    public void changePassword() {
        System.out.println(accountHandler.changePassword(
                collector, "123", "789"));
        System.out.println(accountHandler.changePassword(
                collector, "456", "456"));

    }

    @Test
    public void verifyPassword() {
        System.out.println(accountHandler.verifyPassword(collector, "123"));
        System.out.println(accountHandler.verifyPassword(collector, "456"));
    }

    @Test
    public void changeWechatId() {
        accountHandler.changeWechatId(collector, "夜曲");
    }

    @Test
    public void getAccount() {
        Collector c = new Collector();
        c.setId(4);
        System.out.println(accountHandler.getAccount(c));
    }
}