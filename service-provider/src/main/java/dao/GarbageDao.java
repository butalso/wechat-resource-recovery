package dao;

import entity.Garbage;

import java.util.List;

public interface GarbageDao {

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

}
