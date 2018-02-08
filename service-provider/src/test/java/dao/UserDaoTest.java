package dao;

import entity.Collector;
import entity.Company;
import entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// junit 运行时加载spring-ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    Customer customer;
    Collector collector;
    Company company;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("杰克", "123456",
                "15325678899", "M", 2);

        collector = new Collector("铁柱", "123456",
                "13425809981", "440882199808092213",
                "M", 2);

        company = new Company("回收哥", "123456",
                "15824568897", "440882", "西湖大道7号");

    }

    @Test
    public void addCustomer() {
        userDao.addCustomer(customer);
        System.out.println(customer.getId());
    }

    @Test
    public void getCustomer() {
        System.out.println(userDao.getCustomer(2));
    }

    @Test
    public void updateCustomer() {
        System.out.println("修改前：" + userDao.getCustomer(2));

        customer.setId(2);
        customer.setHousingEstateId(1);
        userDao.updateCustomer(customer);

        System.out.println("修改后：" + userDao.getCustomer(2));
    }

    @Test
    public void deleteCustomer() {
        System.out.println("删除前id=2的用户： " + userDao.getCustomer(2));
        userDao.deleteCustomer(2);
        System.out.println("删除后id=2的用户： " + userDao.getCustomer(2));
    }

    @Test
    public void addCollector() {
        userDao.addCollector(collector);
        System.out.println(collector.getId());
    }

    @Test
    public void getCollector() {
        System.out.println(userDao.getCollector(1));
    }

    @Test
    public void updateCollector() {
        System.out.println("修改id=1的回收员前：" + userDao.getCollector(1));

        collector.setGender("F");
        userDao.updateCollector(collector);

        System.out.println("修改id=1的回收员后：" + userDao.getCollector(1));
    }

    @Test
    public void deleteCollector() {
        System.out.println("删除id=1的回收员前：" + userDao.getCollector(1));
        userDao.deleteCollector(1);
        System.out.println("删除id=1的回收员后：" + userDao.getCollector(1));
    }

    @Test
    public void addCompany() {
        userDao.addCompany(company);
        System.out.println(company.getId());
    }

    @Test
    public void getCompany() {
        System.out.println("id=1的公司信息：" + userDao.getCompany(1));
    }

    @Test
    public void updateCompany() {
        System.out.println("修改前id=1的公司信息：" + userDao.getCompany(1));
        company.setAddrDetail("新城大道8号");
        userDao.updateCompany(company);
        System.out.println("修改后id=1的公司信息：" + userDao.getCompany(1));
    }

    @Test
    public void deleteCompany() {
        System.out.println("删除前id=1的公司信息是：" + userDao.getCompany(1));
        userDao.deleteCompany(1);
        System.out.println("删除后id=1的公司信息是：" + userDao.getCompany(1));
    }
}