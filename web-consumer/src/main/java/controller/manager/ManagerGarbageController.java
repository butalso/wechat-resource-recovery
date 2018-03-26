package controller.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Garbage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.GarbageService;

import java.util.List;

@Controller
@RequestMapping("/manager/garbage")
@Api(tags = "管理员管理废品信息")
public class ManagerGarbageController {
    @Reference
    GarbageService garbageService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation("获取废品种类和废品信息")
    public ModelAndView getGarbageTypes() {
        ModelAndView mav = new ModelAndView("manager/garbageType");
        List<String> garbageTypes = garbageService.getGarbageTypes();
        mav.addObject("garbageTypes", garbageTypes);
        return mav;
    }

    @RequestMapping(value = "/{garbageType}", method = RequestMethod.GET)
    @ApiOperation("获取某类废品信息")
    public ModelAndView getGarbages(@PathVariable("garbageType") String garbageType) {
        ModelAndView mav = new ModelAndView("manager/garbage");
        List<Garbage> garbages = garbageService.getGarbages(garbageType);
        mav.addObject("garbages", garbages);
        return mav;
    }

    @RequestMapping(value = "/{garbageType}", method = RequestMethod.POST)
    @ApiOperation("增添某类废品")
    public ResponseEntity<String> addGarbageType(@RequestParam("typeName") String typeName) {
        garbageService.addGarbageType(typeName);
        return new ResponseEntity<String>("添加成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{garbageType}/{garbageName}", method = RequestMethod.POST)
    @ApiOperation("增添某类废品信息")
    public ResponseEntity<String> addGarbage(@RequestBody Garbage garbage) {
        garbageService.addGarbage(garbage);
        return new ResponseEntity<String>("添加成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{garbageType}/{garbageName}", method = RequestMethod.PUT)
    @ApiOperation("修改废品信息")
    public ResponseEntity<String> updateGarbage(@PathVariable("garbageName") String garbageName,
                                                @RequestBody Garbage garbage) {
        Garbage garbage1 = garbageService.getGrabage(garbageName);
        if (garbage1 == null) {
            return new ResponseEntity<String>("废品不存在", HttpStatus.CREATED);
        }
        garbageService.deleteGarbage(garbage1);
        garbageService.addGarbage(garbage);
        return new ResponseEntity<String>("修改成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{garbageType}/{garbageName}", method = RequestMethod.DELETE)
    @ApiOperation("删除某废品信息")
    public ResponseEntity<String> deleteGarbage(@PathVariable("garbageName") String garbageName) {
        Garbage garbage = garbageService.getGrabage(garbageName);
        if (garbage != null) {
            garbageService.deleteGarbage(garbage);
        }
        return new ResponseEntity<String>("删除成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{garbageType}", method = RequestMethod.DELETE)
    @ApiOperation("删除某类废品信息")
    public ResponseEntity<String> deleteGarbageType(@PathVariable("garbageType") String garbageType) {
        garbageService.delteGarbageType(garbageType);
        return new ResponseEntity<String>("删除成功", HttpStatus.CREATED);
    }

}
