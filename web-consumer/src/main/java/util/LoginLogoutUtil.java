package util;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;
import service.UserActivationService;
import service.UserService;

import javax.servlet.http.HttpSession;

@Service
public class LoginLogoutUtil {

    @Reference
    static UserService userService;
    @Reference
    static UserActivationService userActivationService;

    public static ResponseEntity<String> login(String userName, String password, int userKind,
                                               HttpSession session, ModelMap modelMap) {
        ResponseEntity<String> result = null;

        User user = userService.getUser(userName, userKind);

        if (user == null) {
            /* 用户不存在 */
            result = new ResponseEntity<>("用户不存在", HttpStatus.UNAUTHORIZED);
        } else if (!user.getPassword().equals(password)) {
            /* 密码错误 */
            result = new ResponseEntity<>("密码错误", HttpStatus.UNAUTHORIZED);
        } else {
            /* 密码正确，设置用户登录状态和活跃记录 */
            // TODO 根据用户账号状态对用户进行处理
            user = new User(user.getId(), user.getName(), user.getUserKind());
            userActivationService.addActivation(user, false);
            modelMap.addAttribute("user", user);
            result = new ResponseEntity<>("登录成功", HttpStatus.OK);
        }
        return result;
    }

    public static void logout(SessionStatus sessionStatus, @ModelAttribute("user") User user) {
        /*记录用户活跃状态*/
        userActivationService.addActivation(user, true);
        sessionStatus.setComplete();
    }
}
