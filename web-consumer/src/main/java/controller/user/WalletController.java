package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Wallet;
import exception.LackOfBalanceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.WalletService;
import util.Md5Util;

@Controller
@RequestMapping("/wallet")
@Api(tags = "获取用户钱包及钱包交易记录")
public class WalletController {

    @Reference
    WalletService walletService;

    @RequestMapping(value = "/{walletId}", method = RequestMethod.GET)
    @ApiOperation("获取用户钱包信息页面")
    public ModelAndView getWalletRecord(@PathVariable("walletId") Integer walletId) {
        ModelAndView mav = new ModelAndView("user/walletDetail");

        Wallet wallet = walletService.getWallet(walletId);
        wallet.setPayPassword(null);
        mav.addObject("wallet", wallet);
        mav.addObject("walletRecords", walletService.getWalletRecord(walletId));
        return mav;
    }

    @RequestMapping(value = "/{walletId}", method = RequestMethod.POST)
    @ApiOperation(value = "用户充值或者体现，value为正表示充值，负提现")
    public ResponseEntity<String> recharge(@PathVariable("walletId") Integer walletId,
                                           @RequestParam("payPass") String payPass,
                                           @RequestParam("value") Double value) {
        Wallet wallet = walletService.getWallet(walletId);
        if (!wallet.getPayPassword().equals(Md5Util.getMD5(payPass))) {
            return new ResponseEntity<>("密码错误", HttpStatus.FORBIDDEN);
        }
        try {
            walletService.recharge(wallet, value);
        } catch (LackOfBalanceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("充值提现成功", HttpStatus.CREATED);
    }
}
