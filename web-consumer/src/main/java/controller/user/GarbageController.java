package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Address;
import entity.Garbage;
import entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.AddressService;
import service.GarbageService;
import service.UserService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Controller
@RequestMapping("/garbage")
@SessionAttributes("user")
@Api(tags = "废品价格获取")
public class GarbageController {

    @Reference
    GarbageService garbageService;
    @Reference
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取指定废品信息")
    public Garbage getGarbage(@RequestParam("name") String name) {
        return garbageService.getGrabage(name);
    }

    @RequestMapping(value = "/shoppingCar", method = RequestMethod.GET)
    @ApiOperation(value = "获取废品筐页面")
    public ModelAndView shoppingCart(@ApiIgnore @ModelAttribute("user")User user) {
        ModelAndView mav = new ModelAndView("user/shoppingCar");
        Address address = userService.getUserDetails(user.getName(), user.getUserKind()).getAddress();
        mav.addObject("address", address);
        return mav;
    }


    @RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
    @ApiOperation(value = "获取废品分类页面")
    public String categories() {
        return "user/categories";
    }

    @RequestMapping(value = {"/details"}, method = RequestMethod.GET)
    @ApiOperation(value = "获取废品详细页面")
    public String details() {
        return "user/garbage";
    }
  
}
