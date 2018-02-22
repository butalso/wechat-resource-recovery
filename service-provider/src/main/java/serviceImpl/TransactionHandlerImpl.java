package serviceImpl;

import dao.AccountDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.TransactionHandler;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class TransactionHandlerImpl implements TransactionHandler {
    @Autowired
    AccountDao accountDao;

    @Override
    @Transactional
    public boolean transfer(User from, User to, double value) throws Exception {
        int updateCount;
        try {
            // 减转账人余额
            updateCount = accountDao.updateBalance(from.getId(), from.getUserKind(), -value);
            if(updateCount <= 0) {
                // TODO(抛出异常设置）
                // 余额不足
                throw new RuntimeException("余额不足");
            }
            // 加被转账人余额
            updateCount = accountDao.updateBalance(to.getId(), to.getUserKind(), value);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    @Override
    public boolean withdraw(User user, double value) {
        int userKind = user.getUserKind();
        int userId = user.getId();
        // TODO（提现和转账操作）

        /* 修改账户余额 */
        try {
            accountDao.updateBalance(userId, userKind, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
