package dao;

import entity.Gift;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GiftDao {

    /**
     * 添加礼品
     * @param gift
     */
    void addGift(@Param("gift") Gift gift);

    /**
     * 删除礼品
     * @param id
     */
    void deleteGift(Integer id);

    /**
     * 根据gift的id修改gift信息
     * @param gift
     */
    void updateGift(@Param("gift") Gift gift);

    /**
     * 获取所有礼品
     * @return
     */
    List<Gift> getGifts();
}
