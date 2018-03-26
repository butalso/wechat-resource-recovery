package controller.manager;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manager/message")
@Api(tags = "管理员消息管理")
public class ManagerMessageController {

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String managerSend() {
        return "manager/sendMessage";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity<String> sendMessage() {
        return new ResponseEntity<>("消息发送成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public String managerReceive() {
        return "manager/receiveMessage";
    }
}
