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
@Api(tags = "废品种类，价格获取")
public class GarbageController {

    @Reference
    GarbageService garbageService;

    @RequestMapping(value = "/price", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获取某大类废品价格信息")
    List<Garbage> getGarbages(@RequestParam(value = "name") String garbageType) {
        return garbageService.getGarbages(garbageType);
    }
}
