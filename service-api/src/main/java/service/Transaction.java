package service;

public interface Transaction {
    /**
     * 账号之间转账
     * @param fromAccountId
     * @param toAccountId
     * @param value
     */
    void transfer(int fromAccountId, int toAccountId, double value);

    /**
     * 提现和充值
     * @param accountId
     * @param value
     */
    void withdrawAndrecharge(int accountId, double value);
}
