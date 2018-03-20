package controller.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Collector;
import entity.Company;
import entity.Customer;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping("/manager/user")
public class ManageUserController {
    @Reference
    UserService userService;

    @RequestMapping(value = "/{userKind}", method = RequestMethod.GET)
    public ModelAndView getAllUsers(@PathVariable("userKind") Integer userKind) {
        ModelAndView mav = new ModelAndView("manager/view");
        List<? extends User> myusers = userService.getAllUsers(userKind);
//        switch (userKind) {
//            case 0: mav.addObject("users", (List<Customer>) users);
//                    break;
//            case 1: mav.addObject("users", (List<Collector>) users);
//                    break;
//            default: mav.addObject("users", (List<Company>) users);
//        }
        mav.addObject("myusers", myusers);
        return mav;
    }
}
