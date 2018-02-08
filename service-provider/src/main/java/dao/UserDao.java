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
     * 根据id查询业主实体（卖废品的用户）
     * @param customerId
     * @return
     */
    Customer getCustomer(int customerId);

    /**
     * 根据参数中业主实体id修改业主实体（卖废品的用户）
     * @param customer
     */
    void updateCustomer(@Param("c") Customer customer);

    /**
     * 删除给定id的业主实体（卖废品的用户）
     * @param customerId
     */
    void deleteCustomer(int customerId);

    /**
     * 增加回收员
     * @param collector 完成后设置id到形参中的对象
     */
    void addCollector(@Param("c") Collector collector);

    /**
     * 根据形参id查询回收员信息
     * @param collectorId
     * @return
     */
    Collector getCollector(int collectorId);

    /**
     * 根据参数中回收员实体id修改回收员信息
     * @param collector
     */
    void updateCollector(@Param("c") Collector collector);

    /**
     * 删除参数中回收员信息
     * @param collectorId
     */
    void deleteCollector(int collectorId);

    /**
     * 添加企业
     * @param company
     */
    void addCompany(@Param("c") Company company);

    /**
     * 根据形参id查询企业信息
     * @param companyId
     * @return
     */
    Company getCompany(int companyId);

    /**
     * 根据参数中企业实体id修改回收员信息
     * @param company
     */
    void updateCompany(@Param("c") Company company);

    /**
     * 删除参数中企业信息
     * @param companyId
     */
    void deleteCompany(int companyId);
}
