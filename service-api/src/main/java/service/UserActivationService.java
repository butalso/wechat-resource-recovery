package service;

import entity.User;
import entity.UserActivation;

import java.util.Date;
import java.util.List;

public interface UserActivationService {

    /**
     * 添加当天活跃记录,如果当天活跃记录已存在，修改当天活跃记录
     * @return
     */
    void addActivation(User user, boolean logout);

    /**
     * 获取某用户所有活跃记录
     * @return
     */
    List<UserActivation> getUserActivations(User user);

    /**
     * 获取某天活跃记录
     * @param date
     * @return
     */
    List<UserActivation> getDateActivations(Date date);
}
