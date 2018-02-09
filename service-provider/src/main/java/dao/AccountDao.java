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
                    @Param("ownerId") int ownerId, @Param("ownerKind") int ownerKind);

    /**
     * 查询账户余额
     * @param ownerId
     * @param ownerKind
     * @return
     */
    double getBalance(@Param("ownerId") int ownerId, @Param("ownerKind") int ownerKind);

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
     * 删除账户
     * @param ownerId
     * @param ownerKind
     */
    int deleteAccount(@Param("ownerId") int ownerId,
                       @Param("ownerKind") int ownerKind);
}
