package service;

import entity.Address;

import java.util.List;

/**
 * 实现省市区小区四级联动
 */
public interface AddressLinkage {

    /**
     * 根据address中的最小确认的地址单位，往下查询更具体的地址
     * @param address
     * @return 下级地址集合
     */
    public List<String> linkage(Address address);

}
