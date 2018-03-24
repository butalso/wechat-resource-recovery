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
public class AddressDaoTest {
    @Autowired
    AddressDao addressDao;

    @Test
    public void getProvinces() {
        System.out.println(addressDao.getProvinces());
    }

    @Test
    public void getCities() {
        System.out.println(addressDao.getCities("江苏省"));
    }

    @Test
    public void getAreas() {
        System.out.println(addressDao.getAreas("南京市"));
    }

    @Test
    public void getAddrDetails() {
        System.out.println(addressDao.getAddrDetails("南京市","江宁区", 0));
    }

    @Test
    public void addAddrDetail() {
        addressDao.addAddrDetail("江南老年城", "南京市","江宁区", 0);
    }

    @Test
    public void deleteAddrDetail() {
        addressDao.deleteAddrDetail("江南老年城", "南京市","江宁区");
    }

    @Test
    public void getAddrDetailId() {

        System.out.println(addressDao.getAddrDetailId("江南骏园", "南京市","鼓楼区"));
    }

    @Test
    public void getAddresses() {
        System.out.println(addressDao.getAddresses());
    }
}