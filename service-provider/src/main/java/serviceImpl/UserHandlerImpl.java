package serviceImpl;

import dao.AddressDao;
import dao.UserDao;
import dto.Address;
import entity.Collector;
import entity.Company;
import entity.Customer;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserHandler;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class UserHandlerImpl implements UserHandler {
    @Autowired
    UserDao userDao;
    @Autowired
    AddressDao addressDao;

    @Override
    public void addUser(User user) {
        int userKind = user.getUserKind();
        parseAddress(user);
        switch (userKind) {
            case 0: userDao.addCustomer((Customer) user);
                    break;
            case 1: userDao.addCollector((Collector) user);
                    break;
            case 2: userDao.addCompany((Company) user);
                    break;
        }
    }

    @Override
    public void delUser(String nickName, int userKind) {
        switch (userKind) {
            case 0: userDao.deleteCustomer(nickName);
                break;
            case 1: userDao.deleteCollector(nickName);
                break;
            case 2: userDao.deleteCompany(nickName);
                break;
        }
    }

    @Override
    public void updateUser(User user) {
        int userKind = user.getUserKind();
        parseAddress(user);
        switch (userKind) {
            case 0: userDao.updateCustomer((Customer) user);
                break;
            case 1: userDao.updateCollector((Collector) user);
                break;
            case 2: userDao.updateCompany((Company) user);
                break;
        }
    }

    @Override
    public User getUser(String nickName, int userKind) {
        User result = null;
        switch (userKind) {
            case 0: result = userDao.getCustomer(nickName);
                break;
            case 1: result = userDao.getCollector(nickName);
                break;
            case 2: result = userDao.getCompany(nickName);
                break;
        }
        if (result != null) {
            constructAddress(result);
        }
        return result;
    }

    /**
     * 根据address获取该地址小区号或者是该区行政编号
     * @param user
     * @return
     */
    private void parseAddress(User user) {
        Address address = user.getAddress();
        int hid = 0;
        String areaId;
        areaId = addressDao.getAreaId(address.getArea());
        if (address.getHousingEstate() != null) {
            hid = addressDao.getHousingEstateId(
                    address.getHousingEstate(), areaId);
        }

        switch (user.getUserKind()) {
            case 0: ((Customer) user).setHousingEstateId(hid);
                    break;
            case 1: ((Collector) user).setHousingEstateId(hid);
                    break;
            default:((Company) user).setAreaId(areaId);
        }
        return;
    }

    /**
     * 根据用户小区编号，县行政代号构造地址
     * @param user
     */
    private void constructAddress(User user) {
        Address address;
        switch (user.getUserKind()) {
            case 0: address = addressDao.gethousingEstateAddress(
                    ((Customer) user).getHousingEstateId());
                    break;
            case 1: address = addressDao.gethousingEstateAddress(
                    ((Collector) user).getHousingEstateId());
                    break;
            default: address = addressDao.getAreaAddress(
                    ((Company) user).getAreaId());
        }
        user.setAddress(address);
    }
}
