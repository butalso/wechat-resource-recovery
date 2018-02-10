package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.PersonInfomation;
import entity.Account;
import entity.User;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AccountHandler;
import service.UserHandler;

import java.util.List;

@Controller
@RequestMapping(value = "/personal")
@SessionAttributes("user")
public class Personal {
    @Reference
    UserHandler userHandler;
    @Reference
    AccountHandler accountHandler;

    @RequestMapping(value = "/{userKind}/{nickName}/detail",
            method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public PersonInfomation getUserDetail(@ModelAttribute("user") User user,
                                          @PathVariable Integer userKind,
                                          @PathVariable String nickName) {
        Account account = accountHandler.getAccount(user);
        PersonInfomation pf = new PersonInfomation();
        pf.setUser(user);
        pf.setAccount(account);
        return pf;
    }

    @RequestMapping(value = "/{userKind}/{nickName}/orders",
            method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Order> getOrder(@ModelAttribute("user") User user,
                                @PathVariable Integer userKind,
                                @PathVariable String nickName) {

        return null;
    }


}
