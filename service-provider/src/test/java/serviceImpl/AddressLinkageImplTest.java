package serviceImpl;

import entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AddressLinkage;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class AddressLinkageImplTest {

    @Autowired
    AddressLinkage addressLinkage;

    @Test
    public void linkage() {
        Address address = new Address();
        System.out.println("省份:" + addressLinkage.linkage(address));

        address.setProvince("广东省");
        System.out.println("广东省的市：" + addressLinkage.linkage(address));

        address.setCity("湛江市");
        System.out.println("广东省湛江市的县：" + addressLinkage.linkage(address));
    }
}