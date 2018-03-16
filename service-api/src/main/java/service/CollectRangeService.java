package service;

import dto.Address;

import java.util.List;

public interface CollectRangeService {

    /**
     * 获取回收员所有回收范围
     * @param name
     * @return
     */
    List<Address> getCollectRanges(String name);

    /**
     * 增加回收员回收范围
     * @param name
     * @param address
     */
    void addCollectRange(String name, Address address);

    /**
     * 删除回收员范围
     * @param name
     * @param address
     */
    void deleteCollectRange(String name, Address address);

}
