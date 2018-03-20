package dao;

import dto.Address;
import entity.Collector;
import entity.Company;
import entity.Customer;
import entity.Manager;
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
    Manager manager;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("乔治", "123", "M",
                "11234423110",
                new Address("江苏省", "南京市", "江宁区", "佛城西路八号"));

        collector = new Collector("汤姆", "123", "M", "11234423110",
                "回收哥", "440882199502122234",
                new Address("江苏省", "南京市", "江宁区", "佛城西路八号"));

        company = new Company("废品大叔", "123", "12343242231",
                new Address("江苏省", "南京市", "江宁区", "佛城西路八号"));

        manager = new Manager("陈先生", "123", "M", "12345678901",
                new Address("江苏省", "南京市", "江宁区", null));
    }

    @Test
    public void addCustomer() {
        userDao.addCustomer(customer);
    }

    @Test
    public void getCustomer() {
        System.out.println(userDao.getCustomerDetails("乔治"));
    }

    @Test
    public void updateCustomer() {
        customer = userDao.getCustomerDetails("乔治");
        customer.setGender("F");
        userDao.updateCustomer(customer);
    }

    @Test
    public void deleteCustomer() {
        userDao.deleteCustomer("杰克");
    }

    @Test
    public void addCollector() {
        userDao.addCollector(collector);
    }

    @Test
    public void getCollector() {
        System.out.println(userDao.getCollectorDetails("恐怖利刃"));
    }

    @Test
    public void updateCollector() {
        collector = userDao.getCollectorDetails("恐怖利刃");
        collector.setGender("F");
        userDao.updateCollector(collector);
    }

    @Test
    public void deleteCollector() {
        userDao.deleteCollector("汤姆");
    }

    @Test
    public void addCompany() {
        userDao.addCompany(company);
    }

    @Test
    public void getCompany() {
        System.out.println(userDao.getCompanyDetails("回收哥"));
    }

    @Test
    public void updateCompany() {
        company = userDao.getCompanyDetails("废品大叔");
        company.setPassword("123456");
        userDao.updateCompany(company);
    }

    @Test
    public void deleteCompany() {
        userDao.deleteCompany("废品大叔");
    }


    @Test
    public void addManager() {
        userDao.addManager(manager);
    }

    @Test
    public void getManager() {
        System.out.println(userDao.getManager("陈先生"));
    }

    @Test
    public void updateManager() {
        manager = userDao.getManager("陈先生");
        manager.setPassword("123456");
        userDao.updateManager(manager);
        System.out.println(userDao.getManager("陈先生"));
    }

    @Test
    public void deleteManager() {
        userDao.deleteManager("陈先生");
    }

    @Test
    public void getCustomerBasic() {
        System.out.println(userDao.getCustomerBasic("熊大"));
    }

    @Test
    public void getCollectorBasic() {
        System.out.println(userDao.getCollectorBasic("恐怖利刃"));
    }

    @Test
    public void getCompanyBasic() {
        System.out.println(userDao.getCompanyBasic("回收哥"));
    }

    @Test
    public void getCustomers() {
        System.out.println(userDao.getCustomers());
    }

    @Test
    public void getCollectors() {
        System.out.println(userDao.getCollectors());
    }

    @Test
    public void getCompanys() {
        System.out.println(userDao.getCompanys());
    }
}