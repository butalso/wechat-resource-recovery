package service;

import entity.Account;
import entity.User;

public interface AccountHandler {
    /**
     * 添加用户平台账号
     * @param user
     * @param password
     */
    void addAccount(User user, String wechatId, String password);

    /**
     * 获取用户的账号
     * @param user
     * @return
     */
    Account getAccount(User user);

    /**
     * 修改用户账号密码
     * @param user
     * @param oldPass
     * @param newPass
     * @return
     */
    boolean changePassword(User user, String oldPass, String newPass);

    /**
     * 验证用户支付
     * @param password
     * @return
     */
    boolean verifyPassword(User user, String password);

    /**
     * 修改提现微信账号
     * @param user
     * @param wechatId
     * @return
     */
    boolean changeWechatId(User user, String wechatId);

}
