package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Garbage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.GarbageHandler;

import java.util.List;

@Controller
@RequestMapping("/garbage")
@Api(tags = "废品种类，价格获取")
public class GarbageController {

    @Reference
    GarbageHandler garbageHandler;

    @RequestMapping(value = "/price", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获取某大类废品价格信息")
    List<Garbage> getGarbages(@RequestParam(value = "name") String garbageType) {
        return garbageHandler.getGarbages(garbageType);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "获取废品分类页面")
    public String categories() {
        return "user/categories";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @ApiOperation(value = "获取废品下单页面")
    public String garbage() {
        return "user/garbage";
    }

    @RequestMapping(value = "/shoppingCar", method = RequestMethod.GET)
    @ApiOperation(value = "获取废品筐页面")
    public String shoppingCart() {
        return "user/shoppingCar";
    }
}
