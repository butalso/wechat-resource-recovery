package controller;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.AccountHandler;
import service.UserHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("user")
public class UserController {
    @Reference
    UserHandler userHandler;
    @Reference
    AccountHandler accountHandler;

    @RequestMapping(value = "/info", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User getUserDetail(@ModelAttribute("user") User user) {
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

    @RequestMapping(value = "/register", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public String addUser(@RequestBody User newUser) {
        userHandler.addUser(newUser);
        return "注册成功";
    }





}
