package serviceImpl;

import dto.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.CollectRangeService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class CollectRangeServiceImplTest {
    @Autowired
    CollectRangeService collectRangeService;

    @Test
    public void getCollectRanges() {
        System.out.println(collectRangeService.getCollectRanges("恐怖利刃"));
    }

    @Test
    public void addCollectRange() {
        Address address = new Address("江苏省", "南京市", "江宁区", "国");
        collectRangeService.addCollectRange("恐怖利刃", address);
    }

    @Test
    public void deleteCollectRange() {
    }
}