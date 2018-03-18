package dao;

import dto.Address;
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
public class CollectRangeDaoTest {

    @Autowired
    CollectRangeDao collectRangeDao;

    Address address;

    @Before
    public void setUp() throws Exception {
        address = new Address("江苏省", "南京市", "江宁区", "江南青年城");
    }

    @Test
    public void getCollectRangesId() {
        System.out.println(collectRangeDao.getCollectRangesId("恐怖利刃"));
    }

    @Test
    public void addCollectRange() {
        collectRangeDao.addCollectRange("恐怖利刃", address);
    }

    @Test
    public void deleteCollectRange() {
        collectRangeDao.deleteCollectRange("恐怖利刃", address);
    }

    @Test
    public void deleteCollectRange2() {
        collectRangeDao.deleteCollectRange2(address);
    }
}