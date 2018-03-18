package serviceImpl;

import dto.Address;
import entity.Collector;
import entity.Company;
import entity.Customer;
import entity.Manager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    Customer customer;
    Collector collector;
    Company company;
    Manager manager;
    Address address = new Address("江苏省", "南京市", "江宁区", "佛城西路八号");

    @Before
    public void setUp() {
        customer = new Customer("熊大", "123", "M", "12345678900",
                address);
        collector = new Collector("熊二", "123", "M", "12345678900",
                "回收哥", "440882199823140905", address);
        company = new Company("废品大叔", "123", "12345678900", address);
        manager = new Manager("周先生","123", "M", "12345678900", address);
    }

    @Test
    public void addUser() {
        customer.setName("熊大2");
        userService.addUser(customer);
//        userService.addUser(collector);
//        userService.addUser(company);
//        userService.addUser(manager);
    }

    @Test
    public void delUser() {
        userService.delUser("熊大", 0);
        userService.delUser("熊二", 1);
        userService.delUser("废品大叔", 2);
        userService.delUser("周先生", 3);
    }

    @Test
    public void updateUser() {
        customer = (Customer) userService.getUserDetails("熊大", 0);
        collector = (Collector) userService.getUserDetails("熊二", 1);
        company = (Company) userService.getUserDetails("废品大叔", 2);
        manager = (Manager) userService.getUserDetails("周先生", 3);

        customer.setPassword("123456");
        customer.setPhone("222");
        userService.updateUser(customer);

        collector.setPassword("123456");
        collector.setPhone("222");
        userService.updateUser(collector);

        company.setPassword("123456");
        company.setPhone("222");
        userService.updateUser(company);

        manager.setPassword("123456");
        manager.setPhone("222");
        userService.updateUser(manager);
    }

    @Test
    public void getUser() {
        System.out.println(userService.getUserDetails("狙击手", 0));
        System.out.println(userService.getUserDetails("熊二", 1));
        System.out.println(userService.getUserDetails("废品大叔", 2));
        System.out.println(userService.getUserDetails("周先生", 3));
    }

    @Test
    public void updatePassword() {
        userService.updatePassword("狙击手", 0, "123456", "123");
    }
}