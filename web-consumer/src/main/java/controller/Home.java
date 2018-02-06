package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PCALinkage;

@Controller
@RequestMapping("/")
public class Home {
    @Reference
    PCALinkage pcaLinkage;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        System.out.println(pcaLinkage.getProvinces());
        return "index";
    }
}
