package service;

import dto.Order;
import entity.User;

import java.util.List;
import java.util.Map;

public interface OrderHandler {

    /**
     * 获取用户所有订单
     * @param userId
     * @param userKind
     * @return
     */
    List<Order> getOrders(int userId, int userKind);

    /**
     * 回收员获取回收范围内新订单消息
     * @param collectorId
     * @return
     */
    List<Order> getNewOrders(int collectorId);

    /**
     * 回收员确认接单
     * @param collectorId
     * @param orderId
     */
    void receiveOrder(int collectorId, int orderId);

    /**
     * 用户(业主，回收员）确认订单完成，并且评分
     * @param user
     * @param grade
     */
    void confirmOrderFinish(User user, int orderId, int grade) throws Exception ;

    /**
     * 用户创建订单
     * @param customerId
     * @param garbages
     */
    void createOrder(int customerId, Map<String, Double> garbages);

    /**
     * 回收员更新订单废品信息
     * @param orderId
     * @param garbages
     */
    void updateOrderDetails(Integer orderId, Map<String, String> garbages);
}
