package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserHandler;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Reference
    UserHandler userHandler;

    @RequestMapping(value = "/{userKind}/{nickName}/detail",
            method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User getUserDetail(@PathVariable Integer userKind,
                              @PathVariable String nickName) {
        return userHandler.getUser(nickName, userKind);
    }


}
