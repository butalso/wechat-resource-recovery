package dao;

import entity.UserActivation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserActivationDao {

    /**
     * 添加当天活跃记录
     * @return
     */
    int addActivation(@Param("userId") Integer userId, @Param("userKind") Integer userKind);

    /**
     * 更改活跃记录
     */
    void updateActivation(@Param("userActivation") UserActivation userActivation);

    /**
     * 获取某用户某天活跃记录
     * @param userId
     * @param userKind
     * @param date
     * @return
     */
    UserActivation getUserDateActivation(@Param("userId") Integer userId,
                                         @Param("userKind") Integer userKind,
                                         @Param("date") String date);

    /**
     * 获取某用户所有活跃记录
     * @param userId
     * @param userKind
     * @return
     */
    List<UserActivation> getUserActivations(@Param("userId") Integer userId,
                                            @Param("userKind") Integer userKind);

    /**
     * 获取某天活跃记录
     * @param date
     * @return
     */
    List<UserActivation> getDateActivations(@Param("date") String date);

}
