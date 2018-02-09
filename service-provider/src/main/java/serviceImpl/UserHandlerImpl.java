package serviceImpl;

import dao.UserDao;
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

    @Override
    public void addUser(User user) {
        int userKind = user.getUserKind();
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
        return result;
    }
}
