package dao;

import entity.Collector;
import entity.Company;
import entity.Customer;
import org.apache.ibatis.annotations.Param;

/**
 * 系统使用者（业主、回收员、企业）信息的增删改查
 */
public interface UserDao {

    /**
     * 增加业主实体（卖废品的用户）
     * @param customer 完成后设置id到形参中的对象
     */
    void addCustomer(@Param("c") Customer customer);

    /**
     * 根据用户昵称名查询业主实体（卖废品的用户）
     * @param nickName
     * @return
     */
    Customer getCustomer(String nickName);

    /**
     * 根据参数中业主实体昵称名修改业主实体（卖废品的用户）
     * @param customer
     */
    void updateCustomer(@Param("c") Customer customer);

    /**
     * 删除给定呢称名的业主实体（卖废品的用户）
     * @param nickName
     */
    void deleteCustomer(String nickName);

    /**
     * 增加回收员
     * @param collector 完成后设置id到形参中的对象
     */
    void addCollector(@Param("c") Collector collector);

    /**
     * 根据昵称名查询回收员信息
     * @param nick_name
     * @return
     */
    Collector getCollector(String nick_name);

    /**
     * 根据参数中回收员实体昵称修改回收员信息
     * @param collector
     */
    void updateCollector(@Param("c") Collector collector);

    /**
     * 删除参数中回收员信息
     * @param nickName
     */
    void deleteCollector(String nickName);

    /**
     * 添加企业
     * @param company
     */
    void addCompany(@Param("c") Company company);

    /**
     * 根据企业名查询企业信息
     * @param name
     * @return
     */
    Company getCompany(String name);

    /**
     * 根据参数中企业实体名称修改回收员信息
     * @param company
     */
    void updateCompany(@Param("c") Company company);

    /**
     * 删除参数中企业信息
     * @param name
     */
    void deleteCompany(String name);
}
