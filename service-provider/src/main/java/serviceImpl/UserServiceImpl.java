package serviceImpl;

import dao.AddressDao;
import dao.UserDao;
import dao.WalletDao;
import entity.*;
import exception.AddressNonExistsException;
import exception.PasswordErrorException;
import exception.UserNameExistException;
import exception.UserNonExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    WalletDao walletDao;

    @Autowired
    AddressDao addressDao;

    @Override
    public void addUser(User user) throws UserNameExistException, AddressNonExistsException {
        if (getUserDetails(user.getName(), user.getUserKind()) != null) {
            /*用户已存在*/
            throw new UserNameExistException();
        }
        if (addressDao.getAddrDetailId(user.getAddress().getDetail(), user.getAddress().getArea()) == null) {
            throw new AddressNonExistsException();
        }

        switch (user.getUserKind()) {
            case 0: userDao.addCustomer((Customer) user);
                break;
            case 1: userDao.addCollector((Collector) user);
                break;
            case 2: userDao.addCompany((Company) user);
                break;
            case 3: userDao.addManager((Manager) user);
        }
        if (user.getUserKind() != 3) {
            /*添加用户钱包*/
            walletDao.addWallet(user.getId(), user.getUserKind());
        }
    }

    @Override
    public void delUser(String name, int userKind) {
        int userId = 0;
        // TODO 权限控制
        switch (userKind) {
            case 0: userId = userDao.getCustomerDetails(name).getId();
                    userDao.deleteCustomer(name);
                    break;
            case 1: userId = userDao.getCollectorDetails(name).getId();
                    userDao.deleteCollector(name);
                    break;
            case 2: userId = userDao.getCompanyDetails(name).getId();
                    userDao.deleteCompany(name);
                    break;
            case 3: userDao.deleteManager(name);
        }
        /*删除钱包记录*/
        walletDao.deleteWallet(userId, userKind);
    }

    @Override
    public void updateUser(User user) throws UserNonExistsException, AddressNonExistsException {
        User oldUser = getUserDetails(user.getName(), user.getUserKind());
        if (oldUser == null) {
            /*用户不存在*/
            throw new UserNonExistsException();
        }
        if (addressDao.getAddrDetailId(user.getAddress().getDetail(), user.getAddress().getArea()) == null) {
            throw new AddressNonExistsException();
        }

        Integer addrDetailId = addressDao.getAddrDetailId(
                user.getAddress().getDetail(),
                user.getAddress().getArea());
        if (addrDetailId == null && user.getUserKind() != 3) {
            /*地址错误*/
            throw new AddressNonExistsException();
        }

        switch (user.getUserKind()) {
            case 0: userDao.updateCustomer((Customer) user);
                    break;
            case 1: userDao.updateCollector((Collector) user);
                    break;
            case 2: userDao.updateCompany((Company) user);
                    break;
            case 3: userDao.updateManager((Manager) user);
        }
    }

    @Override
    public User getUserDetails(String name, int userKind) {
        User result = null;
        switch (userKind) {
            case 0: result = userDao.getCustomerDetails(name);
                break;
            case 1: result = userDao.getCollectorDetails(name);
                break;
            case 2: result = userDao.getCompanyDetails(name);
                break;
            case 3: result = userDao.getManager(name);
        }
        return result;
    }

    @Override
    public User getUserBasic(String name, int userKind) {
        User result = null;
        switch (userKind) {
            case 0: result = userDao.getCustomerBasic(name);
                break;
            case 1: result = userDao.getCollectorBasic(name);
                break;
            case 2: result = userDao.getCompanyBasic(name);
                break;
            case 3: result = userDao.getManager(name);
        }
        return result;
    }

    @Override
    public void updatePassword(String name, int userKind, String oldPass, String newPass)
            throws PasswordErrorException {
        User user = getUserDetails(name, userKind);
        if (!user.getPassword().equals(oldPass)) {
            throw new PasswordErrorException();
        }
        user.setPassword(newPass);
        updateUser(user);
    }
}
