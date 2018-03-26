package serviceImpl;

import dao.AddressDao;
import dao.CollectRangeDao;
import dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CollectRangeService;

import java.util.ArrayList;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class CollectRangeServiceImpl implements CollectRangeService {
    @Autowired
    AddressDao addressDao;
    @Autowired
    CollectRangeDao collectRangeDao;

    @Override
    public List<Address> getCollectRanges(String name) {
        List<Integer> ids = collectRangeDao.getCollectRangesId(name);
        List<Address> result = new ArrayList<>();

        for (Integer id : ids) {
            result.add(addressDao.getAddress(id));
        }
        return result;
    }

    @Override
    public void addCollectRange(String name, Address address) {
        collectRangeDao.addCollectRange(name, address);
    }

    @Override
    public void deleteCollectRange(String name, Address address) {
        collectRangeDao.deleteCollectRange(name, address);
    }
}
