package serviceImpl;

import dao.AddressDao;
import dao.CollectRangeDao;
import dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AddressService;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;
    @Autowired
    CollectRangeDao collectRangeDao;

    @Override
    public List<String> linkage(Address address) {
        List<String> result = null;
        if (address.getArea() != null) {
            result = addressDao.getAddrDetails(address.getArea(), 0);
        } else if (address.getCity() != null) {
            result = addressDao.getAreas(address.getCity());
        } else if (address.getProvince() != null){
            result = addressDao.getCities(address.getProvince());
        } else {
            result = addressDao.getProvinces();
        }
        return result;
    }

    @Override
    public List<Address> getAddresss() {
        return null;
    }

    @Override
    public void addAddressDetail(Address address, Integer kind) {
        addressDao.addAddrDetail(address.getDetail(), address.getArea(), kind);
    }

    @Override
    public void delAddressDetail(Address address) {
        /*删除回收员回收范围*/
        collectRangeDao.deleteCollectRange2(address);
        addressDao.deleteAddrDetail(address.getDetail(), address.getArea());
    }

}
