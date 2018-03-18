package dao;

import entity.Wallet;
import org.apache.ibatis.annotations.Param;

public interface WalletDao {
    /**
     * 添加用户钱包
     * @param userId
     * @param userKind
     * @return
     */
    int addWallet(@Param("userId") Integer userId, @Param("userKind") Integer userKind);

    /**
     * 修改密码，修改钱包余额，正值加，负值减
     * @param value
     * @return
     */
    int updateWallet(@Param("id") Integer id, @Param("payPassword") String payPassword, @Param("value") Double value);

    /**
     * 获取钱包信息
     * @param userId
     * @param userKind
     * @return
     */
    Wallet getWallet(@Param("userId") Integer userId, @Param("userKind") Integer userKind);

    /**
     * 删除钱包数据
     * @param userId
     * @param userKind
     */
    void deleteWallet(@Param("userId") Integer userId, @Param("userKind") Integer userKind);

    /**
     * 获取钱包信息
     * @param id
     * @return
     */
    Wallet getWalletById(Integer id);
}
