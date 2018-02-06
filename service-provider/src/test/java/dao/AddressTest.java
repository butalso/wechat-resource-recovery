package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// junit 运行时加载spring-ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class AddressTest {
    @Autowired
    private Address address;

    @Test
    public void queryProvinces() {
        List<String> list = address.queryProvinces();
        System.out.println(list);
    }

    @Test
    public void queryCities() {
    }

    @Test
    public void queryAreas() {
    }
}