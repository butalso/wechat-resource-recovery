package service;

import entity.Garbage;

import java.util.List;

public interface GarbageHandler {

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
}
