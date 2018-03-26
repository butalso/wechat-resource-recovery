package controller.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Address;
import entity.Collector;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.AddressService;
import service.CollectRangeService;
import service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manager/address")
@Api(tags = "管理小区和回收员回收范围")
public class ManagerAddressController {
    @Reference
    AddressService addressService;
    @Reference
    UserService userService;
    @Reference
    CollectRangeService collectRangeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation("获取所有小区")
    public ModelAndView getAddresses() {
        ModelAndView mav = new ModelAndView("manager/address");
        List<Address> addresses = addressService.getAddresss();
        List<Collector> collectors = (List<Collector>)userService.getAllUsers(1);
        Map<String, List<Address>> disAddresses = new HashMap<>();
        for (Collector collector : collectors) {
            List<Address> addresses1 = collectRangeService.getCollectRanges(collector.getName());
            for (Address address : addresses1) {
                if (addresses.contains(address)) {
                    addresses.remove(address);
                }
                List<Address> disAddress1 = disAddresses.get(collector.getName());
                if (disAddress1 == null) {
                    disAddresses.put(collector.getName(), new ArrayList<>());
                    disAddress1 = disAddresses.get(collector.getName());
                }
                disAddress1.add(address);
            }
        }

        mav.addObject("undisAddresses", addresses);
        mav.addObject("disAddresses", disAddresses);
        return mav;
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ApiOperation("删除某小区")
    public ResponseEntity<String> delAddresses(@RequestBody Address address) {
        addressService.delAddressDetail(address);
        return new ResponseEntity<String>("删除成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation("增加小区地址")
    public ResponseEntity<String> addAddress(@RequestBody Address address) {
        addressService.addAddressDetail(address, 0);
        return new ResponseEntity<String>("添加小区成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{collectorName}/collect_range", method = RequestMethod.POST)
    @ApiOperation("分配回收地址")
    public ResponseEntity<String> addCollectRange(@PathVariable("collectorName") String collectorName,
                                                  @RequestBody Address address) {
        collectRangeService.addCollectRange(collectorName, address);
        return new ResponseEntity<String>("添加回收范围成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{collectorName}/collect_range", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("取消某小区分配")
    public ResponseEntity<String> delCollectorCollectRange(@PathVariable("collectorName") String collectorName,
                                                           @RequestBody Address address) {
        collectRangeService.deleteCollectRange(collectorName, address);
        return new ResponseEntity<String>("取消分配成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{collectorName}/collect_range", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取回收员回收范围小区")
    public List<Address> getCollectorCollectRange(@PathVariable("collectorName") String collectorName) {
        List<Address> addresses = addressService.getAddresss();
        return collectRangeService.getCollectRanges(collectorName);
    }



}
