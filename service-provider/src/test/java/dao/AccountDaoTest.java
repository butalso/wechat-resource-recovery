package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

// junit 运行时加载spring-ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class AccountDaoTest {
    @Autowired
    AccountDao accountDao;

    @Test
    public void addAccount() {
        accountDao.addAccount("问月", 3, 0);
        accountDao.addAccount("问月", 2, 1);
//        accountDao.addAccount("问月", 1, 2);
    }

    @Test
    public void getBalance() {
        System.out.println(accountDao.getBalance(1, 0));
    }

    @Test
    public void updateBalance() {
        System.out.println(accountDao.updateBalance(
                2, 1, 200));
//        System.out.println(accountDao.updateBalance(
//                1, 1, -200));
    }

    @Test
    public void deleteAccount() {
        System.out.println(accountDao.deleteAccount(1, 2));
    }
}