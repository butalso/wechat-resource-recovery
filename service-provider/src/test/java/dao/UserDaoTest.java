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
                "15325678899", "狙击", "M", 2);

        collector = new Collector("铁柱", "123456",
                "13425809981", "tiezhu", "回收哥","440882199808092213",
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
        System.out.println(userDao.getCustomer("jack"));
    }

    @Test
    public void updateCustomer() {
        System.out.println("修改前：" + userDao.getCustomer("jack"));

        customer.setHousingEstateId(1);
        userDao.updateCustomer(customer);

        System.out.println("修改后：" + userDao.getCustomer("jack"));
    }

    @Test
    public void deleteCustomer() {
        System.out.println("删除前的jack： " + userDao.getCustomer("jack"));
        userDao.deleteCustomer("jack");
        System.out.println("删除后jack： " + userDao.getCustomer("jack"));
    }

    @Test
    public void addCollector() {
        userDao.addCollector(collector);
        System.out.println(collector.getId());
    }

    @Test
    public void getCollector() {
        System.out.println(userDao.getCollector("tiezhu"));
    }

    @Test
    public void updateCollector() {
        System.out.println("修改前的tiezhu：" + userDao.getCollector("tiezhu"));

        collector.setGender("F");
        userDao.updateCollector(collector);

        System.out.println("修改后的tiezhu：" + userDao.getCollector("tiezhu"));
    }

    @Test
    public void deleteCollector() {
        System.out.println("删除前的tiezhu：" + userDao.getCollector("tiezhu"));
        userDao.deleteCollector("tiezhu");
        System.out.println("删除后的tiezhu：" + userDao.getCollector("tiezhu"));
    }

    @Test
    public void addCompany() {
        userDao.addCompany(company);
        System.out.println(company.getId());
    }

    @Test
    public void getCompany() {
        System.out.println("公司回收哥：" + userDao.getCompany("回收哥"));
    }

    @Test
    public void updateCompany() {
        System.out.println("修改前回收哥：" + userDao.getCompany("回收哥"));
        company.setAddrDetail("新城大道8号");
        userDao.updateCompany(company);
        System.out.println("修改后回收哥：" + userDao.getCompany("回收哥"));
    }

    @Test
    public void deleteCompany() {
        System.out.println("删除前回收哥：" + userDao.getCompany("回收哥"));
        userDao.deleteCompany("回收哥");
        System.out.println("删除后回收哥：" + userDao.getCompany("回收哥"));
    }

    @Test
    public void getCustomerById() {
        System.out.println(userDao.getCustomerById(1));
    }

    @Test
    public void getCollectorById() {
        System.out.println(userDao.getCollectorById(1));
    }

    @Test
    public void getCompanyById() {
        System.out.println(userDao.getCompanyById(1));
    }

    @Test
    public void getCustomersId() {
        System.out.println(userDao.getCustomersId(2));
    }

    @Test
    public void getManager() {
        System.out.println(userDao.getManager("陈先生"));
    }
}