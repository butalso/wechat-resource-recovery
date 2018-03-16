package service;

import entity.Garbage;

import java.util.List;

public interface GarbageService {

    /**
     * 增加废品种类
     * @param name
     */
    void addGarbageType(String name);

    /**
     * 增加废品
     */
    void addGarbage(Garbage garbage);

    /**
     * 删除废品种类
     * @param name
     */
    void delteGarbageType(String name);

    /**
     * 删除废品
     */
    void deleteGarbage(Garbage garbage);

    /**
     * 获取废品种类集合
     * @return
     */
    List<String> getGarbageTypes();

    /**
     * 获取某种废品信息集合
     * @param typeName
     * @return
     */
    List<Garbage> getGarbages(String typeName);

    /**
     * 获取某类废品信息
     * @param name
     * @return
     */
    Garbage getGrabage(String name);
}
