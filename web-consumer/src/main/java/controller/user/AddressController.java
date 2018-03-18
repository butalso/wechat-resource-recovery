package controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Address;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AddressService;
import util.AddressUtil;

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
        return AddressUtil.linkage(province, city, area);
    }

}
