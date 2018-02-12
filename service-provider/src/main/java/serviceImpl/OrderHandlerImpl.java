package serviceImpl;

import dao.*;
import dto.Address;
import dto.Order;
import entity.Garbage;
import entity.OrderDetail;
import entity.OrderItem;
import entity.User;
import enums.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderHandler;

import java.util.*;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class OrderHandlerImpl implements OrderHandler {
    @Autowired
    OrderDao orderDao;

    @Autowired
    UserDao userDao;

    @Autowired
    GarbageDao garbageDao;

    @Autowired
    CollectRangeDao collectRangeDao;

    @Autowired
    AddressDao addressDao;

    /**
     * 用户获取所有相关订单
     * @param userId
     * @param userKind
     * @return
     */
    @Override
    public List<Order> getOrders(int userId, int userKind) {
        List<Integer> itemsId = null;
        switch (userKind) {
            case 0: itemsId = orderDao.customerOrderItems(userId);
                    break;
            case 1: itemsId = orderDao.collectorOrderItems(userId);
                    break;
            case 2: itemsId = orderDao.companyOrderItems(userId);
                    break;
            default: return null;
        }

        List<Order> result = getOrders(itemsId);
        return result;
    }

    /**
     * 根据订单编号获取订单信息
     * @param ordersId
     * @return
     */
    private List<Order> getOrders(List<Integer> ordersId) {
        List<Order> result = new ArrayList<>();
        Order order;
        OrderItem orderItem;
        int hId = 0;
        Address address;
        List<OrderDetail> orderDetails;
        for (Integer id : ordersId) {
            orderItem = orderDao.getOrderItem(id);
            orderDetails = orderDao.getOrderDetails(id);
            order = constructOrder(orderItem, orderDetails);

            hId = userDao.getCustomerById(
                    orderItem.getUserId()).getHousingEstateId();
            address = addressDao.gethousingEstateAddress(hId);
            order.setAddress(address);
            result.add(order);
        }
        return result;
    }

    /**
     * 根据orderItem， orderDetails构造出Order对象
     * @param orderItem
     * @param orderDetails
     * @return
     */
    private Order constructOrder(OrderItem orderItem,
                                 List<OrderDetail> orderDetails) {
        Order result = new Order();
        result.setId(orderItem.getId());
        result.setCreateTime(orderItem.getCreateTime());
        result.setFinishTime(orderItem.getFinishTime());
        result.setStateInfo(
                OrderState.stateOf(orderItem.getState()).getStateInfo());
        result.setCustomerName(
                userDao.getCustomerById(orderItem.getUserId()).getNickName());
        if (orderItem.getState() > 0) {
            /* 回收员已接单 */
            result.setCollectorName(
                    userDao.getCollectorById(orderItem.getCollectorId()).getNickName());
            result.setCompanyName(
                    userDao.getCompanyById(orderItem.getCompanyId()).getName());
        }

        result.setUserGrade(orderItem.getUserGrade());
        result.setCollectorGrade(orderItem.getCollectorGrade());

        Map<Garbage, Double> garbages = new HashMap<>();
        Garbage garbage;
        for (OrderDetail orderDetail : orderDetails) {
            garbage = garbageDao.getGarbage(orderDetail.getGarbageName());
            garbages.put(garbage, orderDetail.getWeight());
        }
        result.setMap(garbages);

        return result;
    }

    /**
     * 回收员获取用户新建订单消息
     * @param collectorId
     * @return
     */
    @Override
    public List<Order> getNewOrders(int collectorId) {
       List<Integer> hIds = collectRangeDao.getCollectRangesId(collectorId);
       List<Integer> cIds = new ArrayList<>();
       /* 获取回收范围内所有业主id存储到cIds中 */
       for (int i = 0; i < hIds.size(); i++) {
            cIds.addAll(
                    userDao.getCustomersId(
                            hIds.get(i)));
       }

       List<Integer> newOrdersId = new ArrayList<>();
       /* 获取所有业主所有新订单存储到newOrdersId中 */
       for (int i = 0; i < cIds.size(); i++) {
            newOrdersId.addAll(
                    orderDao.getNewOrdersId(cIds.get(i)));
       }

        return getOrders(newOrdersId);
    }

    @Override
    public void createOrder(int customerId, Map<String, Double> garbages) {
        OrderItem orderItem = new OrderItem();
        orderDao.createOrder(customerId, orderItem);
        int orderId = orderItem.getId();

        double weight;
        double price;
        for (Map.Entry<String, Double> entry : garbages.entrySet()) {
            weight = entry.getValue();
            price = garbageDao.getGarbage(entry.getKey()).getPrice();
            orderDao.addOrderDetail(orderId, entry.getKey(), weight, price);
        }
    }

    @Override
    public void updateOrderDetails(int orderId, Map<String, Double> garbages) {
        double weight;
        for (Map.Entry<String, Double> entry : garbages.entrySet()) {
            weight = entry.getValue();
            orderDao.updateOrderDetail(orderId, entry.getKey(), weight);
        }
    }

    @Override
    public void receiveOrder(int collectorId, int orderId) {
        String companyName = userDao.getCollectorById(collectorId).getCompanyName();
        int companyId = userDao.getCompany(companyName).getId();
        orderDao.receiveOrder(orderId, collectorId, companyId);
    }

    @Override
    public void confirmOrderFinish(User user, int orderId, int grade) {
        int userKind = user.getUserKind();
        if (userKind == 0) {
            if(user.getId() != orderDao.getOrderItem(orderId).getUserId()) {
                /* 不是订单创建者确认 */
                return;
            }
            int cGrade = orderDao.getOrderItem(orderId).getCollectorGrade();
            orderDao.updateOrderState(orderId, grade, cGrade);
        } else if (userKind == 1) {
            if(user.getId() != orderDao.getOrderItem(orderId).getCollectorId()) {
                /* 不是订单回收者确认 */
                return;
            }
            int uGrade = orderDao.getOrderItem(orderId).getUserGrade();
            orderDao.updateOrderState(orderId, uGrade, grade);
        }
    }
}
