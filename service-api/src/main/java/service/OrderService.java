package service;

import dto.Address;
import dto.Order;
import entity.OrderDetail;
import exception.*;

import java.util.List;

public interface OrderService {

    /**
     * 获取指定订单号的订单
     * @param orderItemId
     * @return
     */
    Order getOrder(Integer orderItemId);

    /**
     * 用户创建订单
     * @param order
     */
    void addOrder(Order order) throws UserNonExistsException, AddressNonExistsException;

    /**
     * 获取用户所有订单
     * @param name
     * @param userKind
     * @return
     */
    List<Order> getOrders(String name, int userKind);

    /**
     * 回收员获取回收范围内新订单消息
     * @param name
     * @return
     */
    List<Order> getNewOrders(String name);

    /**
     * 修正某一订单信息
     * @param orderItemId
     * @param orderDetails
     */
    void updateOrderDetails(Integer orderItemId, List<OrderDetail> orderDetails)
            throws OrderNonExistException, OrderHadBeenPayedException;

    /**
     * 业主删除未完成订单
     * @return
     */
    void delUnfinishOrder(String name, int orderItemId) throws DelOrderFailException;

    /**
     * 回收员确认接单
     * @param name
     * @param orderItemId
     */
    void receiveOrder(String name, int orderItemId) throws OrderHadBeenReceivedException;

    /**
     * 回收员确认订单完成,并向业主转账
     * @param name
     */
    void confirmOrderReceive(String name, int orderItemId)
            throws LackOfBalanceException;

    /**
     * 企业确认订单完成，并向回收员转账
     * @param name
     * @param orderItemId
     */
    void confirmOrderFinish(String name, int orderItemId, String payPassword)
            throws LackOfBalanceException, PasswordErrorException, OrderOwnerException, OrderHadBeenPayedException;

    /**
     * 对以回收订单评分
     * @param name
     * @param useKind
     * @param grade
     */
    void gradeOrder(Integer orderItemId, String name, int useKind, int grade)
            throws OrderNonConfirmedException, OrderHadBeenGradedException;

}
