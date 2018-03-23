package serviceImpl;

import dao.WalletDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.WalletService;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void t() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int size = list.size();
        for (int j = 0; j < size; j++) {
            System.out.println(list.get(j));
            if (j == 2) {
                list.remove(j);
            }
        }
    }
}