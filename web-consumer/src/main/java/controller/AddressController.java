package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import dto.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AddressHandler;

import java.util.List;

@Controller
@RequestMapping(value = "/address")
public class AddressController {
    @Reference
    AddressHandler addressHandler;

    @RequestMapping(value = "/linkage", method = RequestMethod.GET)
    @ResponseBody
    public List<String> linkage(@RequestParam(value = "province", required = false) String province,
                                @RequestParam(value = "city", required = false) String city,
                                @RequestParam(value = "area", required = false) String area) {
        Address address = new Address();
        address.setProvince(province);
        address.setCity(city);
        address.setArea(area);
        return addressHandler.linkage(address);
    }

    @RequestMapping(value = "/housingEstate", method = RequestMethod.POST)
    @ResponseBody
    public String addHousingEstate(@RequestBody Address address) {
        addressHandler.addHousingEstate(address);
        return "添加成功";
    }
}
