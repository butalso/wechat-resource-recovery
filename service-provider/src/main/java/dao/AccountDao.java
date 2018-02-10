package dao;

import entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountDao {

    /**
     * 添加账户，余额为默认值，密码经过md5加密后
     * @param wechatId
     * @param ownerId
     * @param ownerKind
     */
    void addAccount(@Param("wechatId") String wechatId,@Param("password") String password,
                    @Param("ownerId") int ownerId, @Param("ownerKind") int ownerKind);

    /**
     * 获取账号绑定微信号和账号余额
     * @param ownerId
     * @param ownerKind
     * @return
     */
    Account getAccount(@Param("ownerId") int ownerId, @Param("ownerKind") int ownerKind);

    /**
     * 获取账户md5加密后密码
     * @param ownerId
     * @param ownerKind
     * @return
     */
    String getPassword(@Param("ownerId") int ownerId, @Param("ownerKind") int ownerKind);

    /**
     * 修改账号密码
     * @param ownerId
     * @param ownerKind
     * @param password
     * @return
     */
    int updatePassword(@Param("ownerId") int ownerId, @Param("ownerKind") int ownerKind,
                       @Param("password") String password);

    /**
     * 更改用户账户中的余额
     * @param ownerId
     * @param ownerKind
     * @param value
     */
    int updateBalance(@Param("ownerId") int ownerId,
                       @Param("ownerKind") int ownerKind,
                       @Param("value") double value);

    /**
     * 修改提现微信号
     * @param ownerId
     * @param ownerKind
     * @return
     */
    int updateWechatId(@Param("ownerId") int ownerId,
                       @Param("ownerKind") int ownerKind,
                       @Param("wechatId") String wechatId);

    /**
     * 删除账户
     * @param ownerId
     * @param ownerKind
     */
    int deleteAccount(@Param("ownerId") int ownerId,
                       @Param("ownerKind") int ownerKind);
}
