package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Account;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AccountHandler;
import service.TransactionHandler;

@Controller
@RequestMapping(value = "/account")
@SessionAttributes("user")
public class AccountController {

    @Reference
    AccountHandler accountHandler;

    @Reference
    TransactionHandler transactionHandler;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String addAccount(@ModelAttribute("user") User user,
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
    public String changeWechatId(@ModelAttribute("user") User user,
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
    public Account getAccount(@ModelAttribute("user") User user) {
        return accountHandler.getAccount(user);
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    public String changePassword(@ModelAttribute("user") User user,
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
    public String withdraw(@ModelAttribute("user") User user,
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
