package dao;

import dto.Address;
import dto.Order;
import entity.OrderDetail;
import entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    /**
     * 增添订单条目
     * @param orderItem
     * @return
     */
    int addOrderItem(@Param("orderItem") OrderItem orderItem);

    /**
     * 增添订单条目的相关订单详情
     * @param orderItemId
     * @param orderDetails
     * @return
     */
    int addOrderDetails(@Param("orderItemId") Integer orderItemId, @Param("orderDetails") List<OrderDetail> orderDetails);

    /**
     * 删除未转账订单
     * @param orderItemId
     */
    int deleteOrderItem(@Param("orderItemId") Integer orderItemId, @Param("cName") String customerName);

    /**
     * 删除订单详情
     * @param orderItemId
     */
    void deleteOrderDetails(@Param("orderItemId") Integer orderItemId);

    /**
     * 获取业主订单项集合
     * @param name
     * @return
     */
    List<OrderItem> getCustomerOrderItems(@Param("name") String name);

    /**
     * 获取回收员订单项集合
     * @param name
     * @return
     */
    List<OrderItem> getCollectorOrderItems(@Param("name") String name);

    /**
     * 获取回收企业订单项集合
     * @param name
     * @return
     */
    List<OrderItem> getCompanyOrderItems(@Param("name") String name);

    /**
     * 根据订单id获取订单项
     * @param orderItemId
     * @return
     */
    OrderItem  getOrderItem(Integer orderItemId);

    /**
     * 获取订单项订单详情
     * @param orderItemId
     * @return
     */
    List<OrderDetail> getOrderDetails(Integer orderItemId);

    /**
     * 回收员获取回收范围内业主新建状态订单项
     * @param name
     * @return
     */
    List<OrderItem> getNewOrderItems(@Param("name") String name);

    /**
     * 回收员确认接单，更新订单状态
     * @param orderItemId
     * @param collectorName
     */
    int receiveOrder(@Param("oId") Integer orderItemId, @Param("cName") String collectorName);

    /**
     * 回收员确认回收到废品
     * @param orderItemId
     * @param collectorName
     */
    void collectorConfirmReceive(@Param("oId") Integer orderItemId, @Param("cName") String collectorName);

    /**
     * 业主对订单评分
     * @param orderItemId
     * @param grade
     */
    void customerGradeOrder(@Param("oId") Integer orderItemId, @Param("grade") Integer grade, @Param("cName") String customerName);

    /**
     * 回收员对订单评分
     * @param orderItemId
     * @param grade
     */
    void collectorGradeOrder(@Param("oId") Integer orderItemId, @Param("grade") Integer grade, @Param("cName") String collectorName);

    /**
     * 企业确认订单完成
     * @param orderItemId
     */
    void finishOrder(@Param("oId") int orderItemId, @Param("cName") String name);
}
