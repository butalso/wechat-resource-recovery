package dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {

    /**
     * 添加账户，余额为默认值
     * @param wechatId
     * @param ownerId
     * @param ownerKind
     */
    void addAccount(@Param("wechatId") String wechatId,
                    @Param("ownerId") int ownerId, int ownerKind);

    /**
     * 查询用户给定微信号的账户编号
     * @param wechatId
     * @param ownerId
     * @param ownerKind
     * @return
     */
    int getAccountId(@Param("wechatId") String wechatId,
                     @Param("ownerId") int ownerId, int ownerKind);

    /**
     * 查询账户余额
     * @param accountId
     * @return
     */
    double getBalance(@Param("accountId") int accountId);

    /**
     * 更改账户accountId中的余额
     * @param accountId
     * @param value
     */
    void updateBalance(@Param("accountId") int accountId,
                       @Param("value") double value);

    /**
     * 删除账户
     * @param accountId
     */
    void deleteAccount(@Param("accountId") int accountId);
}
