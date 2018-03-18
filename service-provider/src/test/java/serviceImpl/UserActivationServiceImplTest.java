package serviceImpl;

import entity.Customer;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserActivationService;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class UserActivationServiceImplTest {

    @Autowired
    UserActivationService userActivationService;

    @Test
    public void addActivation() {
//        userActivationService.addActivation(new Customer(1, "狙击手"), false);
//        userActivationService.addActivation(new Customer(1, "狙击手"), true);
    }

    @Test
    public void getUserActivations() {
//        System.out.println(userActivationService.getUserActivations(new Customer(1, "狙击手")));
    }

    @Test
    public void getDateActivations() {
        System.out.println(userActivationService.getDateActivations(new Date()));
    }
}