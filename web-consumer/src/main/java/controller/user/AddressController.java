package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Address;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AddressService;

import java.util.List;

@Controller
@RequestMapping(value = "/address")
@Api(tags = "地址信息管理")
public class AddressController {
    @Reference
    AddressService addressService;

    @RequestMapping(value = "/linkage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "地址联动控制", notes = "根据最小确认地址单位获取下一级地址单位集合")
    public List<String> linkage(@RequestParam(value = "province", required = false) String province,
                                @RequestParam(value = "city", required = false) String city,
                                @RequestParam(value = "area", required = false) String area) {
        Address address = new Address();
        address.setProvince(province);
        address.setCity(city);
        address.setArea(area);
        return addressService.linkage(address);
    }

    @RequestMapping(value = "/housingEstate", method = RequestMethod.POST,
        produces = "text/plain;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "根据地址县和小区名称，添加小区")
    public String addHousingEstate(@RequestBody Address address) {
//        addressService.addAddressDetail(address);
        return "添加成功";
    }
}
