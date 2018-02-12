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
     * 查询区的行政代号
     * @param area
     * @return
     */
    String getAreaId(String area);

    /**
     * 查询参数中县级市中所有小区
     * @param area
     * @return
     */
    List<String> getHousingEstates(String area);

    /**
     * 根据小区号查询该小区完整地址
     * @param housingEstateId
     * @return
     */
    Address gethousingEstateAddress(int housingEstateId);

    /**
     * 根据县级市行政编号查询该县级市完整地址
     * @param areaId
     * @return
     */
    Address getAreaAddress(String areaId);

    void addHousingEstate(@Param("name") String name, @Param("areaId") String areaId);

    void delHousingEstate(@Param("name") String name, @Param("areaId") String areaId);

    int getHousingEstateId(@Param("name") String name, @Param("areaId") String areaId);

}
