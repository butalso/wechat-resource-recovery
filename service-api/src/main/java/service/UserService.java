package service;

import entity.User;
import exception.AddressNonExistsException;
import exception.UserNameExistException;
import exception.UserNonExistsException;

/**
 * 用户（业主、回收员、企业）的增删改查
 */
public interface UserService {
    /**
     * 添加用户
     * @param user
     */
    void addUser(User user) throws UserNameExistException, AddressNonExistsException;

    /**
     * 删除用户
     * @param name
     * @param userKind
     */
    void delUser(String name, int userKind);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user) throws UserNonExistsException, AddressNonExistsException;

    /**
     * 获取用户信息
     * @param name
     * @param userKind
     * @return
     */
    User getUser(String name, int userKind);
}
