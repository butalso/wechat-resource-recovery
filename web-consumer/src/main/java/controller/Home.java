package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.User;
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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class Home {

    @Reference
    UserHandler userHandler;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,
        produces = "text/plain;charset=utf-8")
    public ResponseEntity<String> login(@RequestParam("userName") String userName,
                                        @RequestParam("password") String password,
                                        @RequestParam("userKind") int userKind,
                                        HttpSession session, ModelMap modelMap) {
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
            modelMap.addAttribute("user", user);
            result = new ResponseEntity<>("登录成功", HttpStatus.OK);
        }
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:index";
    }
}
