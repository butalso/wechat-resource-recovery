package dao;

import entity.WalletRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WalletRecordDao {

    /**
     * 获取钱包所有交易记录
     * @param walletId
     * @return
     */
    List<WalletRecord> getWalletRecords(Integer walletId);

    /**
     * 添加钱包交易记录
     * @param transfer
     * @param receiver
     * @param value
     */
    void addWalletRecord(@Param("w_id") Integer walletId,
                         @Param("t") String transfer,
                         @Param("r") String receiver,
                         @Param("v") Double value);
}
