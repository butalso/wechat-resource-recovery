package serviceImpl;

import dao.UserDao;
import dao.WalletDao;
import dao.WalletRecordDao;
import entity.Wallet;
import entity.WalletRecord;
import exception.LackOfBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.WalletService;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletDao walletDao;
    @Autowired
    WalletRecordDao walletRecordDao;
    @Autowired
    UserDao userDao;

    @Override
    public void transfer(Wallet fromWallet, Wallet toWallet, double value) throws LackOfBalanceException {
        /*保留两位小数*/
        value = (double) Math.round(value * 100) / 100;
        /*回收员向用户转账*/
        int update = walletDao.updateWallet(fromWallet.getId(), fromWallet.getPayPassword(), -value);
        if (update <= 0) {
            throw new LackOfBalanceException();
        }
        walletDao.updateWallet(toWallet.getId(), toWallet.getPayPassword(), value);

        walletRecordDao.addWalletRecord(fromWallet.getId(),
                getWalletOwner(fromWallet.getUserId(), fromWallet.getUserKind()),
                getWalletOwner(toWallet.getUserId(), toWallet.getUserKind()), value);
    }

    /**
     * 返回钱包所有者的名字
     * @param id
     * @param userKind
     * @return
     */
    private String getWalletOwner(Integer id, Integer userKind) {
        switch (userKind) {
            case 0: return "customer:" + userDao.getCustomerBasicById(id).getName();
            case 1: return "collector:" + userDao.getCollectorBasicById(id).getName();
            case 2: return "company:" + userDao.getCompanyBasicById(id).getName();
        }
        return "";
    }

    @Override
    public void recharge(Wallet wallet, double value) throws LackOfBalanceException{
        // TODO:充值提现真实操作
        int update = walletDao.updateWallet(wallet.getId(), wallet.getPayPassword(), value);
        if (update <= 0) {
            throw new LackOfBalanceException();
        }
        walletRecordDao.addWalletRecord(wallet.getId(),
                getWalletOwner(wallet.getUserId(), wallet.getUserKind()),
                getWalletOwner(wallet.getUserId(), wallet.getUserKind()), value);
    }

    @Override
    public List<WalletRecord> getWalletRecord(Integer walletId) {
        return walletRecordDao.getWalletRecords(walletId);
    }

    @Override
    public Wallet getWallet(Integer id) {
        return walletDao.getWalletById(id);
    }
}
