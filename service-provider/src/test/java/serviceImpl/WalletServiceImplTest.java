package serviceImpl;

import dao.WalletDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.WalletService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class WalletServiceImplTest {

    @Autowired
    WalletDao walletDao;

    @Autowired
    WalletService walletService;

    @Test
    public void transfer() {
        walletService.transfer(walletDao.getWallet(2, 1),
                walletDao.getWallet(1, 0), 5000);
    }

    @Test
    public void recharge() {
        walletService.recharge(walletDao.getWallet(1, 0), -1100);
    }

    @Test
    public void getWalletRecord() {
        System.out.println(walletService.getWalletRecord(13));
    }
}