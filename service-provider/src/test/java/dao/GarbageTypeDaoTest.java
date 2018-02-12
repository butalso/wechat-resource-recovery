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
public class GarbageTypeDaoTest {

    @Autowired
    GarbageTypeDao garbageTypeDao;

    @Test
    public void getGarbageTypes() {
        System.out.println(garbageTypeDao.getGarbageTypes());
    }
}