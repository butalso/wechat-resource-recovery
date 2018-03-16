package serviceImpl;

import dao.AddressDao;
import dao.UserDao;
import dao.WalletDao;
import entity.*;
import exception.AddressNonExistsException;
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
        if (getUser(user.getName(), user.getUserKind()) != null) {
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
            case 0: userId = userDao.getCustomer(name).getId();
                    userDao.deleteCustomer(name);
                    break;
            case 1: userId = userDao.getCollector(name).getId();
                    userDao.deleteCollector(name);
                    break;
            case 2: userId = userDao.getCompany(name).getId();
                    userDao.deleteCompany(name);
                    break;
            case 3: userDao.deleteManager(name);
        }
        /*删除钱包记录*/
        walletDao.deleteWallet(userId, userKind);
    }

    @Override
    public void updateUser(User user) throws UserNonExistsException, AddressNonExistsException {
        User oldUser = getUser(user.getName(), user.getUserKind());
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

        /* 用户保留登陆密码 */
        user.setPassword(oldUser.getPassword());
        setUserInfo(oldUser, user);

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

    /**
     * 保留非用户可修改的个人信息
     * @param oldUser
     * @param user
     */
    private void setUserInfo(User oldUser, User user) {
        if (user.getUserKind() == 3 || user.getUserKind() == 2) {
            /* 管理员、企业信息全部可以修改 */
            return;
        }
        if (user.getUserKind() == 1) {
            /*回收员保留账户余额、支付密码、所属企业、信誉值、经验值、积分值*/
            Collector cuser = (Collector) user;
            Collector coldUser = (Collector) user;
            cuser.setCompanyName(coldUser.getCompanyName());
            cuser.setCredit(coldUser.getCredit());
            cuser.setExperience(coldUser.getExperience());
            cuser.setPoint(coldUser.getPoint());
        }
        if (user.getUserKind() == 0) {
            /*业主保留账户余额、支付密码、信誉值、经验值、积分值*/
            Customer cuser = (Customer) user;
            Customer coldUser = (Customer) user;
            cuser.setCredit(coldUser.getCredit());
            cuser.setExperience(coldUser.getExperience());
            cuser.setPoint(coldUser.getPoint());
        }
    }

    @Override
    public User getUser(String name, int userKind) {
        User result = null;
        switch (userKind) {
            case 0: result = userDao.getCustomer(name);
                break;
            case 1: result = userDao.getCollector(name);
                break;
            case 2: result = userDao.getCompany(name);
                break;
            case 3: result = userDao.getManager(name);
        }
        return result;
    }

}
