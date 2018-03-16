package service;

import entity.Gift;

import java.util.List;

public interface GiftService {
    /**
     * 添加礼品
     * @param gift
     */
    void addGift(Gift gift);

    /**
     * 删除礼品
     * @param id
     */
    void deleteGift(Integer id);

    /**
     * 根据gift的id修改gift信息
     * @param gift
     */
    void updateGift(Gift gift);

    /**
     * 获取所有礼品
     * @return
     */
    List<Gift> getGifts();
}
