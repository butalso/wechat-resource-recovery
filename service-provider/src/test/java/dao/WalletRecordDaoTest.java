package dao;

import dto.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

// junit 运行时加载spring-ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class WalletRecordDaoTest {

    @Autowired
    WalletRecordDao walletRecordDao;

    @Test
    public void getWalletRecords() {
        System.out.println(walletRecordDao.getWalletRecords(13));
    }

    @Test
    public void addWalletRecord() {
//        walletRecordDao.addWalletRecord(13, "熊大", "狙击手", 22d);
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("a", "a", "a", "a"));
        addresses.add(new Address("b", "b", "b", "b"));
        addresses.add(new Address("c", "c", "c", "c"));

        Address a = new Address("b", "b", "b", "b");
        if (addresses.contains(a)) {
            addresses.remove(a);
        }
        System.out.println(addresses);
    }
}