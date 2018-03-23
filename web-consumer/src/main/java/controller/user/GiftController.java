package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.ECPUser;
import entity.Gift;
import entity.User;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.GiftService;
import service.UserService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Controller
@RequestMapping("/gift")
@SessionAttributes("user")
@Api(tags = "小礼品")
public class GiftController {

    @Reference
    GiftService giftService;
    @Reference
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getGifts() {
        ModelAndView mav = new ModelAndView("user/gift");
        List<Gift> gifts = giftService.getGifts();
        mav.addObject("gifts", gifts);
        return mav;
    }

    @RequestMapping(value = "/{giftId}", method = RequestMethod.POST)
    public ResponseEntity<String> changeGift(@ApiIgnore @ModelAttribute("user")User user,
                                             @PathVariable("giftId") Integer giftId) {
        Gift gift = giftService.getGift(giftId);
        ECPUser user1 = (ECPUser)userService.getUserDetails(user.getName(), user.getUserKind());
        if (user1.getPoint() < gift.getPoint()) {
            return new ResponseEntity<>("积分不足", HttpStatus.FORBIDDEN);
        } else if (gift.getInventory() <= 0) {
            return new ResponseEntity<>("库存不足", HttpStatus.FORBIDDEN);
        }
        user1.setPoint(user1.getPoint() - gift.getPoint());
        userService.updateUser(user1);
        gift.setInventory(gift.getInventory() - 1);
        giftService.updateGift(gift);
        // TODO:添加用户礼品记录
        return new ResponseEntity<>("兑换成功", HttpStatus.CREATED);
    }
}