package serviceImpl;

import dao.AccountDao;
import entity.Account;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AccountHandler;
import util.Md5Util;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class AccountHandlerImpl implements AccountHandler {
    @Autowired
    AccountDao accountDao;

    @Override
    public void addAccount(User user, String wechatId, String password) {
        String md5Password = Md5Util.getMD5(password);
        accountDao.addAccount(wechatId, md5Password,
                user.getId() ,user.getUserKind());
    }

    @Override
    public Account getAccount(User user) {
        return accountDao.getAccount(user.getId(), user.getUserKind());
    }

    @Override
    public boolean changePassword(User user, String oldPass, String newPass) {
        if (!verifyPassword(user, oldPass)) {
            /* 旧密码不正确 */
            return false;
        }
        int updateCount = accountDao.updatePassword(
                user.getId(), user.getUserKind(), Md5Util.getMD5(newPass));
        if (updateCount <= 0) {
            /* 密码修改错误 */
            return false;
        }
        return true;
    }

    @Override
    public boolean verifyPassword(User user, String password) {
        String md5password = accountDao.getPassword(
                user.getId(), user.getUserKind());
        return md5password.equals(Md5Util.getMD5(password));
    }

    @Override
    public boolean changeWechatId(User user, String wechatId) {
        int updateCount = accountDao.updateWechatId(
                user.getId(), user.getUserKind(), wechatId);
        return updateCount > 0;
    }
}
