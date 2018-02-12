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
        System.out.println("所有省份：");
        System.out.println(addressDao.getProvinces());
    }

    @Test
    public void getCities() {
        System.out.println("广东省所有的市：");
        System.out.println(addressDao.getCities("广东省"));
    }

    @Test
    public void getAreas() {
        System.out.println("湛江市所有的县：");
        System.out.println(addressDao.getAreas("湛江市"));
    }

    @Test
    public void gethousingEstateAddress() {
        System.out.println(addressDao.gethousingEstateAddress(2));
    }

    @Test
    public void getAreaAddress() {
        System.out.println("雷州市地址：");
        System.out.println(addressDao.getAreaAddress("440882"));
    }

    @Test
    public void getAreaId() {
        System.out.println("雷州市行政代码：");
        System.out.println(addressDao.getAreaId("雷州市"));
    }

    @Test
    public void addHousingEstate() {
        addressDao.addHousingEstate("金利小区", "440882");
        addressDao.addHousingEstate("福泉小区", "440882");
        addressDao.addHousingEstate("金易小区", "440882");
        System.out.println("雷州市所有的小区：");
        System.out.println(addressDao.getHousingEstates("雷州市"));
    }

    @Test
    public void delHousingEstate() {
        addressDao.delHousingEstate("金易小区", "440882");
        System.out.println("雷州市所有的小区：");
        System.out.println(addressDao.getHousingEstates("雷州市"));
    }

    @Test
    public void getHousingEstateId() {
        System.out.println(addressDao.getHousingEstateId("金利小区", "440882"));
    }
}