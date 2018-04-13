package controller.wechat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/wechat")
public class HomePages {

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getPage() {
        return "wechat/page";
    }

    @RequestMapping(value = "/QRCode", method = RequestMethod.GET)
    public String getQRCode() {
        return "wechat/code";
    }
}
