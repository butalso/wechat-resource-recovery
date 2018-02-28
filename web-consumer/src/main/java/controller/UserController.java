package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.*;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.AccountHandler;
import service.UserHandler;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("user")
@Api(tags = "用户信息控制")
public class UserController {
    @Reference
    UserHandler userHandler;
    @Reference
    AccountHandler accountHandler;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getUserDetail(@ModelAttribute("user") User user) {
        switch (user.getUserKind()) {
            case 0: return "customer";
            case 1: return "collector";
            default: return "company";
        }
    }

    @RequestMapping(value = "/info/detail", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User ajaxGetUserDetail(@ModelAttribute("user") User user) {
        return user;
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateUserDetail(@ModelAttribute("user") User user,
                                   @RequestBody Map userInfo,
                                   ModelMap modelMap) {
        User newUser = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(userInfo);
            switch (user.getUserKind()) {
                /* 解析json字符串到实体 */
                case 0: newUser = mapper.readValue(json, Customer.class);
                        ((Customer)newUser).setCredit(
                                ((Customer)user).getCredit());
                        break;
                case 1: newUser = mapper.readValue(json, Collector.class);
                        ((Collector)newUser).setCredit(
                                ((Collector)user).getCredit());
                        break;
                default: newUser = mapper.readValue(json, Company.class);
            }
            newUser.setId(user.getId());
            newUser.setPassword(user.getPassword());
            userHandler.updateUser(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败";
        }
        newUser.setCreateTime(user.getCreateTime());
        modelMap.addAttribute("user", newUser);
        return "修改成功";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addUser() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public String addUser(@RequestBody Map userInfo) {
        User newUser = null;
        try {
            newUser = mapToUser(userInfo);
            newUser.setPassword((String) userInfo.get("password"));
            userHandler.addUser(newUser);
        } catch (IOException e) {
            e.printStackTrace();
            return "注册失败";
        }
        return "注册成功";
    }

    private User mapToUser(Map userInfo) throws IOException {
        User newUser = null;
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(userInfo);
        Integer userKind = (Integer) userInfo.get("userKind");

        switch (userKind) {
            /* 解析json字符串到实体 */
            case 0:
                newUser = mapper.readValue(json, Customer.class);
                break;
            case 1:
                newUser = mapper.readValue(json, Collector.class);
                break;
            default:
                newUser = mapper.readValue(json, Company.class);
        }

        return newUser;
    }

}
