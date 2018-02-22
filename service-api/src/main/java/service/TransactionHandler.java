package service;

import entity.User;

public interface TransactionHandler {
    /**
     * 账号之间转账eded2we2`r`rt
     * @param from
     * @param to
     * @param value
     * @return true操作成功，false操作失败
     */
    boolean transfer(User from, User to, double value) throws Exception;

    /**
     * 提现和充值
     * @param user
     * @param value 正值提现，负值充值
     * @return true操作成功，false操作失败
     */
    boolean withdraw(User user, double value);
}
