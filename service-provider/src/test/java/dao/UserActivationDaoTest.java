package dao;

import entity.UserActivation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

// junit 运行时加载spring-ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserActivationDaoTest {

    @Autowired
    UserActivationDao userActivationDao;

    String date;

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.format(new Date());
    }

    @Test
    public void addActivation() {
        userActivationDao.addActivation(1, 0);
    }

    @Test
    public void updateActivation() {
        userActivationDao.updateActivation(
                new UserActivation(1, 0, date, new Date(), 20));
    }

    @Test
    public void getUserDateActivation() {
        System.out.println(userActivationDao.getUserDateActivation(1, 0, date));
    }

    @Test
    public void getUserActivations() {
        System.out.println(userActivationDao.getUserActivations(1, 0));
    }

    @Test
    public void getDateActivations() {
        System.out.println(userActivationDao.getDateActivations(date));
    }
}