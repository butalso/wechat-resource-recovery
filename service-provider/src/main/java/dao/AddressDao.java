package dao;

import dto.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地址相关操作查询
 */
public interface AddressDao {

    /**
     * 查询所有省份
     * @return
     */
    List<String> getProvinces();

    /**
     * 查询参数中省份的所有地级市
     * @param province
     * @return
     */
    List<String> getCities(String province);

    /**
     * 查询参数中地级市的所有县级市
     * @param city
     * @return
     */
    List<String> getAreas(String city);

    /**
     * 查询参数中县级市中地址详情
     * @param area
     * @return
     */
    List<String> getAddrDetails(@Param("area") String area, @Param("kind") Integer kind);

    /**
     * 增添地址详情
     * @param name
     * @param area
     * @param kind
     */
    void addAddrDetail(@Param("name") String name,
                       @Param("area") String area, @Param("kind") Integer kind);

    /**
     * 删除地址详情
     * @param name
     * @param area
     */
    void deleteAddrDetail(@Param("name") String name, @Param("area") String area);

    /**
     * 获取地址详情的id，主要用来判断地址存不存在
     * @param name
     * @param area
     * @return
     */
    Integer getAddrDetailId(@Param("name") String name, @Param("area") String area);

    /**
     * 根据地址详情id获取完整地址
     * @param addrDetailId
     * @return
     */
    Address getAddress(@Param("addrDetailId") Integer addrDetailId);


}
