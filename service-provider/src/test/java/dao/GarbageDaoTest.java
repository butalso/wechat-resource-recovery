package dao;

import entity.Garbage;
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
public class GarbageDaoTest {

    @Autowired
    GarbageDao garbageDao;

    @Test
    public void getGarbage() {
        System.out.println(garbageDao.getGarbage("废纸箱"));
    }

    @Test
    public void getGarbages() {
        System.out.println(garbageDao.getGarbages("废纸"));
    }

    @Test
    public void getGarbageTypes() {
        System.out.println(garbageDao.getGarbageTypes());
    }

    @Test
    public void addGarbageType() {
        garbageDao.addGarbageType("自行车");
    }

    @Test
    public void addGarbage() {
        garbageDao.addGarbage(new Garbage("自行车", "凤凰牌", 22.2));
    }

    @Test
    public void delteGarbageType() {
        garbageDao.delteGarbageType("自行车");
    }

    @Test
    public void deleteGarbage() {
        garbageDao.deleteGarbage(new Garbage("自行车", "凤凰牌"));
    }
}