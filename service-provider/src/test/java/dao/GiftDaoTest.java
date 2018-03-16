package dao;

import entity.Gift;
import org.junit.Before;
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
public class GiftDaoTest {

    @Autowired
    GiftDao giftDao;
    Gift gift;

    @Before
    public void setUp() throws Exception {
        gift = new Gift("蓝月亮", 20, 100);
    }

    @Test
    public void addGift() {
        giftDao.addGift(gift);
    }

    @Test
    public void deleteGift() {
        giftDao.deleteGift(1);
    }

    @Test
    public void updateGift() {
        gift = giftDao.getGifts().get(0);
        gift.setInventory(200);
        giftDao.updateGift(gift);
    }

    @Test
    public void getGifts() {
        System.out.println(giftDao.getGifts());
    }
}