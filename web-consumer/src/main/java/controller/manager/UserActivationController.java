package controller.manager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/manager/user_activation")
@Controller
@Api(tags = "管理员获取用户活跃度")
public class UserActivationController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation("获取用户活跃度页面")
    public String getUserActivation() {
        return "manager/userActivation";
    }
}
