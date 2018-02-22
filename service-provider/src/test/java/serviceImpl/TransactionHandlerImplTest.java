package serviceImpl;

import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.TransactionHandler;
import service.UserHandler;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class TransactionHandlerImplTest {

    @Autowired
    TransactionHandler transactionHandler;
    @Autowired
    UserHandler userHandler;

    User customer;
    User collector;

    @Before
    public void setUp() throws Exception {
        customer = userHandler.getUser("jack", 0);
        collector = userHandler.getUser("tiezhu", 1);
    }

    @Test
    public void transfer() throws Exception{
        transactionHandler.transfer(collector, customer, 150);
    }

    @Test
    public void withdraw() {
        transactionHandler.withdraw(collector, -100);
    }
}