package service;

import dto.Address;

import java.util.List;

/**
 * 实现省市区小区地址相关操作
 */
public interface AddressHandler {

    /**
     * 根据address中的最小确认的地址单位，往下查询更具体的地址
     * @param address
     * @return 下级地址集合
     */
    List<String> linkage(Address address);

    /**
     * 添加小区
     * @param address
     */
    void addHousingEstate(Address address);

    /**
     * 删除小区
     * @param address
     */
    void delHousingEstate(Address address);

}
