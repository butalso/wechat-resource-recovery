package dao;

import entity.Garbage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GarbageDao {

    /**
     * 增加废品种类
     * @param name
     */
    void addGarbageType(String name);

    /**
     * 增加废品
     */
    void addGarbage(@Param("g") Garbage garbage);

    /**
     * 删除废品种类
     * @param name
     */
    void delteGarbageType(String name);

    /**
     * 删除废品
     */
    void deleteGarbage(@Param("g") Garbage garbage);

    /**
     * 获取废品信息
     * @param name
     * @return
     */
    Garbage getGarbage(String name);

    /**
     * 获取给定类型名的所有废品信息
     * @param typeName
     * @return
     */
    List<Garbage> getGarbages(String typeName);

    /**
     * 获取所有废品集合
     * @return
     */
    List<String> getGarbageTypes();

}
