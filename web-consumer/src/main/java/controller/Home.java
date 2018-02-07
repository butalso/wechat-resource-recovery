package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AddressLinkage;

@Controller
@RequestMapping("/")
public class Home {
    @Reference
    AddressLinkage addressLinkage;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
//        System.out.println(addressLinkage.getProvinces());
        return "index";
    }
}
