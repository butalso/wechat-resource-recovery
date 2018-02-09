package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.AddressHandler;
import service.UserHandler;

@Controller
@RequestMapping("/")
public class Home {

    @Reference
    UserHandler userHandler;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam("userKind") Integer userKind) {
        ResponseEntity<String> result = null;

        User user = userHandler.getUser(userName, userKind);

        if (user == null) {
            /* 用户不存在 */
            result = new ResponseEntity<>("用户不存在", HttpStatus.UNAUTHORIZED);
        } else if (!user.getPassword().equals(password)) {
            /* 密码错误 */
            result = new ResponseEntity<>("密码错误", HttpStatus.UNAUTHORIZED);
        } else {
            /* 密码错误 */
            result = new ResponseEntity<>("登录成功", HttpStatus.OK);
        }
        return result;
    }
}
