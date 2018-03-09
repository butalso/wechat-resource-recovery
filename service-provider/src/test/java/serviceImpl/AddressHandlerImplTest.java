package serviceImpl;

import dto.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AddressHandler;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class AddressHandlerImplTest {

    @Autowired
    AddressHandler addressHandler;

    @Test
    public void linkage() {
        Address address = new Address();
        System.out.println("省份:" + addressHandler.linkage(address));

        address.setProvince("广东省");
        System.out.println("广东省的市：" + addressHandler.linkage(address));

        address.setCity("湛江市");
        System.out.println("广东省湛江市的县：" + addressHandler.linkage(address));
    }

    @Test
    public void addHousingEstate() {
        Address address = new Address();
        address.setArea("雷州市");
//        address.setHousingEstate("天河小区");

        addressHandler.addHousingEstate(address);
    }

//    @Test
//    public void getHousingEstates() {
//        System.out.println(addressHandler.getHousingEstates("雷州市"));
//    }

    @Test
    public void delHousingEstate() {
        Address address = new Address();
        address.setArea("雷州市");
//        address.setHousingEstate("天河小区");

        addressHandler.delHousingEstate(address);
    }

}