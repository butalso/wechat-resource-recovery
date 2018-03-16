package service;

import dto.Address;

import java.util.List;

/**
 * 实现省市区地址详情相关操作
 */
public interface AddressService {
    /**
     * 根据address中的最小确认的地址单位，往下查询更具体的地址
     * @param address
     * @return 下级地址集合
     */
    List<String> linkage(Address address);

    /**
     * 添加地址详情
     * @param address
     */
    void addAddressDetail(Address address, Integer kind);

    /**
     * 删除地址详情
     * @param address
     */
    void delAddressDetail(Address address);

}
