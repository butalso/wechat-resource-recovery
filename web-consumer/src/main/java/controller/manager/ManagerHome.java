package controller.manager;

import entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import springfox.documentation.annotations.ApiIgnore;
import util.LoginLogoutUtil;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager")
public class ManagerHome {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "manager/login";
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
                                        @ApiIgnore HttpSession session,
                                        @ApiIgnore ModelMap modelMap) {
        return LoginLogoutUtil.login(userName, password, 3, session, modelMap);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home() {
        return "manager/index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ApiOperation(value = "登出，重定向到登录页面")
    public String logout(SessionStatus sessionStatus, @ModelAttribute("user") User user) {
        LoginLogoutUtil.logout(sessionStatus, user);
        return "redirect:manager/login";
    }
}
