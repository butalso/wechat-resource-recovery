package dao;

import entity.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.Md5Util;

// junit 运行时加载spring-ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class AccountDaoTest {
    @Autowired
    AccountDao accountDao;

    @Test
    public void addAccount() {
//        accountDao.addAccount("问月", "123",3, 0);
//        accountDao.addAccount("问月", "123",2, 1);
        accountDao.addAccount("问月", "123",1, 1);

    }

    @Test
    public void updateBalance() {
        System.out.println(accountDao.updateBalance(
                0, 1, 200));
//        System.out.println(accountDao.updateBalance(
//                1, 1, -200));
    }

    @Test
    public void deleteAccount() {
        System.out.println(accountDao.deleteAccount(2, 1));
    }

    @Test
    public void getPassword() {
        String password = accountDao.getPassword(3, 0);
        Assert.assertEquals(password, Md5Util.getMD5("123"));
    }

    @Test
    public void updatePassword() {
        accountDao.updatePassword(3, 0, "456");
    }

    @Test
    public void updateWechatId() {
        accountDao.updateWechatId(1, 2, "夜曲");
    }

    @Test
    public void getAccount() {
        Account account = accountDao.getAccount(0, 1);
        System.out.println(account);
    }
}