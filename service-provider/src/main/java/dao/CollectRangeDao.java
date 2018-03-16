package dao;

import dto.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectRangeDao {

    /**
     * 获取回收员的回收范围
     * @param name
     * @return
     */
    List<Integer> getCollectRangesId(String name);

    /**
     * 增加回收员回收范围
     * @param name
     * @param address
     */
    void addCollectRange(@Param("name") String name, @Param("address") Address address);

    /**
     * 删除回收员范围
     * @param name
     * @param address
     */
    void deleteCollectRange(@Param("name") String name, @Param("address") Address address);

    /**
     * 删除该小区所有回收员范围
     * @param address
     */
    void deleteCollectRange2(@Param("address") Address address);


}
