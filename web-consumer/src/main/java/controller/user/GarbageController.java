package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Garbage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.GarbageService;

import java.util.List;

@Controller
@RequestMapping("/garbage")
@Api(tags = "废品价格获取")
public class GarbageController {

    @Reference
    GarbageService garbageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取指定废品信息")
    public Garbage getGarbage(@RequestParam("name") String name) {
        return garbageService.getGrabage(name);
    }

    @RequestMapping(value = "/shoppingCar", method = RequestMethod.GET)
    @ApiOperation(value = "获取废品筐页面")
    public String shoppingCart() {
        return "user/shoppingCar";
    }
}
