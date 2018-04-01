package controller.user;


import com.alibaba.dubbo.config.annotation.Reference;
import entity.Customer;
import entity.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import service.UserService;
import springfox.documentation.annotations.ApiIgnore;
import util.LoginLogoutUtil;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
@Api(tags = "获取首页，控制用户登录、登出、注册")
public class UserHome {
    @Reference
    UserService userService;

    @RequestMapping(value = {"", "/index"}, method = RequestMethod.GET)
    @ApiOperation(value = "获取用户首页")
    public String userHome() {
        return "user/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation(value = "获取登录页面")
    public String login() {
        return "user/login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ApiOperation(value = "获取注册页面")
    public String register() {
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8",
            produces = "text/plain;charset=UTF-8")
    @ApiOperation(value = "处理用户注册，用户需要填写地址，性别，用户名，密码，电话")
    public ResponseEntity<String> addUser(@RequestBody Customer customer) {
        ResponseEntity<String> result = null;

        try {
            userService.addUser(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("注册成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8")
    @ApiOperation(value = "处理用户登录信息")
    @ApiResponses({
            @ApiResponse(code = 401, message = "用户不存在或密码错误"),
    })
    public ResponseEntity<String> login(@ApiParam(value = "用户名", required = true)
                                            @RequestParam("userName") String userName,
                                        @ApiParam(value = "密码", required = true)
                                            @RequestParam("password") String password,
                                        @ApiParam(value = "用户类型,0代表业主，1代表回收员，2代表企业", required = true)
                                            @RequestParam("userKind") int userKind,
                                        @ApiIgnore HttpSession session, @ApiIgnore ModelMap modelMap) {
        return LoginLogoutUtil.login(userName, password, userKind, session, modelMap);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ApiOperation(value = "登出，重定向到首页")
    public String logout(@ApiIgnore SessionStatus sessionStatus, @ApiIgnore @ModelAttribute("user") User user) {
        LoginLogoutUtil.logout(sessionStatus, user);
        return "redirect:index";
    }

}
