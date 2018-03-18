package service;

import entity.Wallet;
import entity.WalletRecord;
import exception.LackOfBalanceException;

import java.util.List;

public interface WalletService {

    /**
     * 转账操作
     * @param fromWallet
     * @param toWallet
     * @param value
     * @throws LackOfBalanceException
     */
    void transfer(Wallet fromWallet, Wallet toWallet, double value)
            throws LackOfBalanceException;

    /**
     * 充值，提现操作，value为正表示充值，负为体现
     * @param wallet
     * @param value
     */
    void recharge(Wallet wallet, double value) throws LackOfBalanceException;

    /**
     * 获取钱包交易记录
     * @param walletId
     * @return
     */
    List<WalletRecord> getWalletRecord(Integer walletId);

    /**
     * 获取钱包信息
     * @param walletId
     * @return
     */
    Wallet getWallet(Integer walletId);
}
