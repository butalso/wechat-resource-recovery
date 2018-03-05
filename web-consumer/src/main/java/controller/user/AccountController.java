package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Account;
import entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AccountHandler;
import service.TransactionHandler;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping(value = "/account")
@SessionAttributes("user")
@Api(tags = "用户余额账户管理")
public class AccountController {

    @Reference
    AccountHandler accountHandler;

    @Reference
    TransactionHandler transactionHandler;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "给系统当前登录者创建余额账户")
    public String addAccount(@ApiIgnore @ModelAttribute("user") User user,
                             @RequestParam("wechatId") String wechatId,
                             @RequestParam("password") String password) {
        if (accountHandler.getAccount(user) != null) {
            return "账户已存在";
        } else {
            if (wechatId == null || password == null) {
                return "信息不完整";
            }
            accountHandler.addAccount(user, wechatId, password);
        }
        return "添加账户成功";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改余额账户用于提现充值的微信号")
    public String changeWechatId(@ApiIgnore @ModelAttribute("user") User user,
                             @RequestParam("wechatId") String wechatId) {
        if (accountHandler.getAccount(user) == null) {
            return "账户不存在";
        }
        if (accountHandler.changeWechatId(user, wechatId)) {
            return "修改账户成功";
        };
        return "修改账户失败";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "返回余额账户信息")
    public Account getAccount(@ApiIgnore @ModelAttribute("user") User user) {
        return accountHandler.getAccount(user);
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改余额账户交易密码")
    public String changePassword(@ApiIgnore @ModelAttribute("user") User user,
                                @RequestParam("oldPass") String oldPass,
                                 @RequestParam("newPass") String newPass) {
        if (!accountHandler.verifyPassword(user, oldPass)) {
            return "旧密码不正确";
        }
        if (accountHandler.changePassword(user, oldPass, newPass)) {
            return "密码修改成功";
        }
        return "密码修改失败";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "余额账户提现或者充值")
    public String withdraw(@ApiIgnore @ModelAttribute("user") User user,
                                 @RequestParam("value") Double value) {
        try {
            if (value < 0) {
                // TODO 微信账户充值
                /* 充值操作*/
            }
            transactionHandler.withdraw(user, value);
        } catch (Exception e) {
            e.printStackTrace();
            return "充值提现失败";
        }
        return "充值提现成功";
    }
}
