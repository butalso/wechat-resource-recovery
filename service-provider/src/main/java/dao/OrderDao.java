package dao;

import dto.Order;
import entity.OrderDetail;
import entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    /**
     * 用户创建订单
     * @param userId 创建者id
     * @return 订单编号
     */
    int createOrder(@Param("userId") int userId, @Param("orderItem") OrderItem orderItem);

    /**
     * 回收员确认接单，更新订单状态
     * @param orderId
     * @param collectorId
     */
    void receiveOrder(@Param("oId") int orderId, @Param("cId") int collectorId,
                      @Param("comId") int companyId);

    /**
     * 回收员回收订单结束，更新订单状态
     * @param userGarde
     * @param collectorGarde
     */
    void updateOrderState(@Param("oId") int orderId, @Param("uGrade") int userGarde,
                          @Param("cGrade") int collectorGarde);

    /**
     * 增加订单详情
     * @param orderId 订单编号
     * @param garbageName 废品名称
     * @param weight 废品重量
     * @param price 交易时废品单价
     * @return
     */
    int addOrderDetail(@Param("oId") int orderId, @Param("gName") String garbageName,
                        @Param("weight") double weight, @Param("price") double price);

    /**
     * 修正订单详情
     * @param orderId 订单编号
     * @param garbageName 废品名称
     * @param weight 废品重量
     * @return
     */
    int updateOrderDetail(@Param("oId") int orderId, @Param("gName") String garbageName,
                          @Param("weight") double weight);

    /**
     * 用户取消订单
     * @param orderId
     * @return 删除订单行数
     */
    int delOrder(int orderId);

    /**
     * 取消订单时，删除订单详情
     * @param orderId
     * @return
     */
    int delOrderDetails(int orderId);

    /**
     * 获取订单详情信息
     * @param orderId
     * @return
     */
    List<OrderDetail> getOrderDetails(int orderId);

    /**
     * 获取订单项信息
     * @param orderId
     * @return
     */
    OrderItem getOrderItem(int orderId);

    /**
     * 获取业主新建状态订单
     * @param customerId
     * @return
     */
    List<Integer> getNewOrdersId(int customerId);

    List<Integer> customerOrderItems(int customerId);

    List<Integer> collectorOrderItems(int collectorId);

    List<Integer> companyOrderItems(int companyId);

}
