package service;

import entity.User;

/**
 * 用户（业主、回收员、企业）的增删改查
 */
public interface UserHandler {
    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户，公司nickName=name
     * @param nickName
     * @param userKind
     */
    void delUser(String nickName, int userKind);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 获取用户信息，公司nickName=name
     * @param nickName
     * @param userKind
     * @return
     */
    User getUser(String nickName, int userKind);
}
