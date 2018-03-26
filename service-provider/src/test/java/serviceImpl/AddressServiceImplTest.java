package serviceImpl;

import dto.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AddressService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class AddressServiceImplTest {
    @Autowired
    AddressService addressService;

    @Test
    public void linkage() {
        System.out.println(addressService.linkage(new Address("江苏省", null, null, null)));
        System.out.println(addressService.linkage(new Address("江苏省", "南京市", null, null)));
        System.out.println(addressService.linkage(new Address("江苏省", "南京市", "江宁区", null)));
    }

    @Test
    public void addAddressDetail() {
        addressService.addAddressDetail(new Address("江苏省", "南京市", "江宁区", "江南老年城"), 0);
    }

    @Test
    public void delAddressDetail() {
        addressService.delAddressDetail(new Address("江苏省", "南京市", "江宁区", "国"));
    }

    @Test
    public void getAddresss() {
        System.out.println(addressService.getAddresss());
    }
}