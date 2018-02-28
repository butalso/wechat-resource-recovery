package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Garbage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.GarbageHandler;

import java.util.List;

@Controller
@RequestMapping("/garbage")
@Api(tags = "废品种类，价格获取")
public class GarbageController {

    @Reference
    GarbageHandler garbageHandler;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取某大类废品价格信息")
    List<Garbage> getGarbages(@RequestParam(value = "garbageType") String garbageType) {
        return garbageHandler.getGarbages(garbageType);
    }
}
