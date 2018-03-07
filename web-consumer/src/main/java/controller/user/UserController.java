package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.*;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.AccountHandler;
import service.UserHandler;
import springfox.documentation.annotations.ApiIgnore;

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
    @ApiOperation(value = "返回用户个人中心页面")
    public String getUserDetail(@ApiIgnore @ModelAttribute("user") User user) {
        switch (user.getUserKind()) {
            case 0: return "user/customer";
            case 1: return "user/collector";
            case 2: return "user/company";
            default: return "manager/index";
        }
    }

    @RequestMapping(value = "/info/detail", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "ajax获取用户个人具体信息")
    public User ajaxGetUserDetail(@ApiIgnore @ModelAttribute("user") User user) {
        return user;
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8",
            produces = "texp/plain;charset=UTF-8")
    @ApiOperation(value = "修改更新个人信息", notes = "格式：" +
            "业主：{\n" +
            "    \"name\": \"小华仔\",\n" +
            "    \"phone\": \"15867620882\",\n" +
            "    \"address\": {\n" +
            "        \"province\": \"广东省\",\n" +
            "        \"city\": \"湛江市\",\n" +
            "        \"area\": \"雷州市\",\n" +
            "        \"housingEstate\": \"召唤森林\"\n" +
            "    },\n" +
            "    \"userKind\": 0,\n" +
            "    \"nickName\": \"狙击手\",\n" +
            "    \"gender\": \"F\"\n" +
            "}\n" +
            "回收员：{\n" +
            "    \"name\": \"问自己\",\n" +
            "    \"phone\": \"13822105068\",\n" +
            "    \"address\": {\n" +
            "        \"province\": \"广东省\",\n" +
            "        \"city\": \"湛江市\",\n" +
            "        \"area\": \"雷州市\",\n" +
            "        \"housingEstate\": \"青青草原\"\n" +
            "    },\n" +
            "    \"userKind\": 1,\n" +
            "    \"nickName\": \"巫医\",\n" +
            "    \"companyName\": \"回收哥\",\n" +
            "    \"gender\": \"M\",\n" +
            "    \"idcardNo\": \"130682199005066998\"\n" +
            "}\n" +
            "企业：{\n" +
            "    \"name\": \"回收哥哥\",\n" +
            "    \"phone\": \"13825672120\",\n" +
            "    \"address\": {\n" +
            "        \"province\": \"广东省\",\n" +
            "        \"city\": \"湛江市\",\n" +
            "        \"area\": \"遂溪县\"\n" +
            "    },\n" +
            "    \"addrDetail\": \"西湖大道18号\"\n" +
            "}"
    )
    @ApiImplicitParams({@ApiImplicitParam(name = "userInfo", value = "用户个人信息",required = true, paramType = "body")})
    @ApiResponses({@ApiResponse(code = 403, message = "请求体信息缺少或格式不正确"),
            @ApiResponse(code = 201, message = "用户修改数据成功")
    })
    public ResponseEntity<String> updateUserDetail(@ApiIgnore @ModelAttribute("user") User user,
                                           @RequestBody Map userInfo,
                                           @ApiIgnore ModelMap modelMap) {
        ResponseEntity<String> result = null;

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
            return new ResponseEntity<>("修改失败", HttpStatus.FORBIDDEN);
        }
        newUser.setCreateTime(user.getCreateTime());
        modelMap.addAttribute("user", newUser);
        return new ResponseEntity<>("修改成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ApiOperation(value = "返回用户注册页面")
    public String addUser() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8")
    public ResponseEntity<String> addUser(@RequestBody Map userInfo) {
        ResponseEntity<String> result = null;

        User newUser = null;
        try {
            newUser = mapToUser(userInfo);
            newUser.setPassword((String) userInfo.get("password"));
            userHandler.addUser(newUser);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("注册成功", HttpStatus.CREATED);
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
