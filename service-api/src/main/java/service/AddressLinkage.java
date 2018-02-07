package service;

import entity.Address;

import java.util.List;

/**
 * 实现省市区小区四级联动
 */
public interface AddressLinkage {

    public List<String> linkage(Address address);

}
