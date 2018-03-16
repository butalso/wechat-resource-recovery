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
public class WalletDaoTest {

    @Autowired
    WalletDao walletDao;

    @Test
    public void addWallet() {
        walletDao.addWallet(1, 0);
        walletDao.addWallet(2, 1);
        walletDao.addWallet(2, 2);
    }

    @Test
    public void updateWallet() {
        walletDao.updateWallet(1,"e10adc3949ba59abbe56e057f20f883e", -50d);
        walletDao.updateWallet(1,"e10adc3949ba59abbe56e057f20f883e", 100d);
    }

    @Test
    public void getWallet() {
        System.out.println(walletDao.getWallet(1, 0));
    }

    @Test
    public void deleteWallet() {
        walletDao.deleteWallet(1, 0);
    }
}