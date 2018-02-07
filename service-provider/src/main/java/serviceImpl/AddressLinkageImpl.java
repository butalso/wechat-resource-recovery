package serviceImpl;

import dao.AddressDao;
import entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AddressLinkage;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class AddressLinkageImpl implements AddressLinkage {
    @Autowired
    AddressDao addressDao;

    @Override
    public List<String> linkage(Address address) {
        List<String> result = null;
        if (address.getArea() != null) {
            result = addressDao.getHousingEstates(address.getArea());
        } else if (address.getCity() != null) {
            result = addressDao.getAreas(address.getCity());
        } else if (address.getProvince() != null){
            result = addressDao.getCities(address.getProvince());
        } else {
            result = addressDao.getProvinces();
        }
        return result;
    }
}
