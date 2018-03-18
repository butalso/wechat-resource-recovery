package util;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Address;
import org.springframework.stereotype.Service;
import service.AddressService;

import java.util.List;

@Service
public class AddressUtil {
    @Reference
    static AddressService addressService;


    public static List<String> linkage(String province, String city,
                                String area) {
        Address address = new Address();
        address.setProvince(province);
        address.setCity(city);
        address.setArea(area);
        return addressService.linkage(address);
    }
}
