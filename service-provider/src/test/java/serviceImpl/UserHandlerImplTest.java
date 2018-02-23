package serviceImpl;

import dto.Address;
import entity.Collector;
import entity.Company;
import entity.Customer;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
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
                "13425809981", "tiezhu", "回收哥","440882199808092213",
                "M", 2);

        company = new Company("回收哥", "123456",
                "15824568897", "440882", "西湖大道7号");

    }

    @Test
    public void addUser() {
//        userHandler.addUser(customer);
        userHandler.addUser(collector);
//        userHandler.addUser(company);
    }

    @Test
    public void delUser() {
        userHandler.delUser("jack", 0);
        userHandler.delUser("tiezhu", 1);
        userHandler.delUser("回收哥", 2);
    }

    @Test
    public void updateUser() {
        Address address = new Address();
        address.setProvince("广东省");
        address.setCity("湛江市");
        address.setArea("雷州市");
        address.setHousingEstate("青青草原");

        User c1 = userHandler.getUser("影魔", 0);
        User c2 = userHandler.getUser("恐怖利刃", 1);
        User c3 = userHandler.getUser("回收哥", 2);

        c1.setAddress(address);
        c2.setAddress(address);
        c3.setAddress(address);

        c1.setPassword("1234");
        c2.setPassword("1234");
        c3.setPassword("1234");
        userHandler.updateUser(c1);
        userHandler.updateUser(c2);
        userHandler.updateUser(c3);
    }

    @Test
    public void getUser() {
        System.out.println(userHandler.getUser("狙击手", 0));
        System.out.println(userHandler.getUser("巫医", 1));
        System.out.println(userHandler.getUser("回收哥", 2));
    }

}