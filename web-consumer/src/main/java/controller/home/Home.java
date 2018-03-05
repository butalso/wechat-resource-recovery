package controller.home;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import service.UserHandler;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
@Api(tags = "获取首页，控制用户登录、登出、注册")
public class Home {

    @Reference
    UserHandler userHandler;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    @ApiOperation(value = "获取首页")
    public String userHome() {
        return "user/index";
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    @ApiOperation(value = "获取管理员登录页面")
    public String managerHome() {
        return "manager/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation(value = "获取登录页面")
    public String login() {
        return "index/login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ApiOperation(value = "获取注册页面")
    public String register() {
        return "index/register";
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
                                        @ApiParam(value = "用户类型,0代表业主，1代表回收员，2代表企业, 3代表管理员", required = true)
                                            @RequestParam("userKind") int userKind,
                                        @ApiIgnore HttpSession session, @ApiIgnore ModelMap modelMap) {
        ResponseEntity<String> result = null;

        User user = userHandler.getUser(userName, userKind);

        if (user == null) {
            /* 用户不存在 */
            result = new ResponseEntity<>("用户不存在", HttpStatus.UNAUTHORIZED);
        } else if (!user.getPassword().equals(password)) {
            /* 密码错误 */
            result = new ResponseEntity<>("密码错误", HttpStatus.UNAUTHORIZED);
        } else {
            /* 密码正确，设置用户登录状态 */
            // TODO 用户账号状态
            modelMap.addAttribute("user", user);
            result = new ResponseEntity<>("登录成功", HttpStatus.OK);
        }
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ApiOperation(value = "登出，重定向到首页")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:index";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ApiOperation(value = "获取废品分类页面")
    public String categories() {
        return "index/categories";
    }

    @RequestMapping(value = "/garbage", method = RequestMethod.GET)
    @ApiOperation(value = "获取废品下单页面")
    public String garbage() {
        return "index/garbage";
    }

    @RequestMapping(value = "/shoppingCar", method = RequestMethod.GET)
    @ApiOperation(value = "获取废品筐页面")
    public String shoppingCart() {
        return "index/shoppingCar";
    }
}
