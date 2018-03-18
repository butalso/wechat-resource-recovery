package serviceImpl;

import dao.GiftDao;
import entity.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GiftService;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class GiftServiceImpl implements GiftService {
    @Autowired
    GiftDao giftDao;

    @Override
    public void addGift(Gift gift) {
        giftDao.addGift(gift);
    }

    @Override
    public void deleteGift(Integer id) {
        giftDao.deleteGift(id);
    }

    @Override
    public void updateGift(Gift gift) {
        giftDao.updateGift(gift);
    }

    @Override
    public List<Gift> getGifts() {
        return giftDao.getGifts();
    }

    @Override
    public Gift getGift(Integer id) {
        return giftDao.getGift(id);
    }
}
