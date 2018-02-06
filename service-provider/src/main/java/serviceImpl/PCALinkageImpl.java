package serviceImpl;

import dao.Address;
import org.springframework.beans.factory.annotation.Autowired;
import service.PCALinkage;

import java.util.List;

@com.alibaba.dubbo.config.annotation.Service
public class PCALinkageImpl implements PCALinkage {
    @Autowired
    Address address;
    @Override
    public List<String> getProvinces() {
        return address.queryProvinces();
    }

    @Override
    public List<String> getCities(String province) {
        return null;
    }

    @Override
    public List<String> getAreas(String city) {
        return null;
    }
}
