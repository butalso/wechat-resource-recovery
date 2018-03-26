package controller.manager;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/manager/user_activation")
@Controller
@Api(tags = "用户活跃度")
public class UserActivationController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getUserActivation() {
        return "manager/userActivation";
    }
}
