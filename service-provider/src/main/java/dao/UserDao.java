package dao;

import entity.Collector;
import entity.Company;
import entity.Customer;
import entity.Manager;
import exception.UserNameExistException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统使用者（业主、回收员、企业、管理员）信息的增删改查
 */
public interface UserDao {

    /**
     * 增加业主实体
     * @param customer
     */
    void addCustomer(@Param("c") Customer customer);

    /**
     * 根据用户昵称名查询业主实体（卖废品的用户）
     * @param name
     * @return
     */
    Customer getCustomer(String name);

    /**
     * 根据参数中业主用户名修改业主实体（卖废品的用户）
     * @param customer
     */
    void updateCustomer(@Param("c") Customer customer);

    /**
     * 删除给定用户名的业主实体（卖废品的用户）
     * @param name
     */
    void deleteCustomer(String name);

    /**
     * 增加回收员
     * @param collector
     */
    void addCollector(@Param("c") Collector collector);

    /**
     * 根据用户名查询回收员信息
     * @param name
     * @return
     */
    Collector getCollector(String name);

    /**
     * 根据参数中回收员id修改回收员信息
     * @param collector
     */
    void updateCollector(@Param("c") Collector collector);

    /**
     * 删除参数中回收员信息
     * @param name
     */
    void deleteCollector(String name);

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

    /**
     * 增添管理员
     * @param manager
     */
    void addManager(@Param("m") Manager manager);

    /**
     * 获取管理员信息
     * @param name
     * @return
     */
    Manager getManager(String name);

    /**
     * 修改管理员信息
     * @param manager
     */
    void updateManager(@Param("m") Manager manager);

    /**
     * 删除管理员
     * @param name
     */
    void deleteManager(String name);
}
