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
import service.TransactionHandler;

import java.util.*;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class OrderHandlerImpl implements OrderHandler {
    private final double drawPercentage = 0.05;

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

    @Autowired
    TransactionHandler transactionHandler;

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

//            hId = userDao.getCustomerById(
//                    orderItem.getUserId()).getHousingEstateId();
//            address = addressDao.gethousingEstateAddress(hId);
//            order.setAddress(address);
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
//        result.setCustomerName(
//                userDao.getCustomerById(orderItem.getUserId()).getNickName());
        if (orderItem.getState() > 0) {
            /* 回收员已接单 */
//            if(userDao.getCollectorById(orderItem.getCollectorId()) != null) {
//                result.setCollectorName(
//                        userDao.getCollectorById(orderItem.getCollectorId()).getNickName());
//            }
//            if (userDao.getCompanyById(orderItem.getCompanyId()) != null) {
//                result.setCompanyName(
//                        userDao.getCompanyById(orderItem.getCompanyId()).getName());
//            }
        }

        result.setUserGrade(orderItem.getUserGrade());
        result.setCollectorGrade(orderItem.getCollectorGrade());
        result.setOrderDetails(orderDetails);

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
        // TODO 用户创建订单成功后通知回收员
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
    public void updateOrderDetails(Integer orderId, Map<String, String> garbages) {
        for (Map.Entry<String, String> entry : garbages.entrySet()) {
            orderDao.updateOrderDetail(orderId, entry.getKey(), Double.parseDouble(entry.getValue()));
        }
    }

    @Override
    public void receiveOrder(int collectorId, int orderId) {
        String companyName = userDao.getCollectorById(collectorId).getCompanyName();
        int companyId = userDao.getCompany(companyName).getId();
        orderDao.receiveOrder(orderId, collectorId, companyId);
    }

    @Override
    public void confirmOrderFinish(User user, int orderId, int grade) throws Exception {
        int userKind = user.getUserKind();
        User customer = userDao.getCustomerById(
                orderDao.getOrderItem(orderId).getUserId());
        User collector = userDao.getCollectorById(
                orderDao.getOrderItem(orderId).getCollectorId());
        User company = userDao.getCompanyById(
                orderDao.getOrderItem(orderId).getCompanyId());

        if (userKind == 0) {
            if(user.getId() != customer.getId()) {
                /* 不是订单创建者确认 */
                return;
            }
            int cGrade = orderDao.getOrderItem(orderId).getCollectorGrade();
            orderDao.updateOrderState(orderId, grade, cGrade);
        } else if (userKind == 1) {
            if(user.getId() != collector.getId()) {
                /* 不是订单回收者确认 */
                return;
            }
            int uGrade = orderDao.getOrderItem(orderId).getUserGrade();

            try {
                /* 公司向用户转账 */
                transactionHandler.transfer(company, customer, getOrderValue(orderId));
                orderDao.updateOrderState(orderId, uGrade, grade);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        } else {
            /* 公司向回收员转账 */
            try {
                transactionHandler.transfer(company, collector, getOrderValue(orderId) * drawPercentage);
                orderDao.finishOrder(orderId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Double getOrderValue(int orderId) {
        Double value = 0d;
        /* 转账业务 */
        List<OrderDetail> orderDetails = orderDao.getOrderDetails(orderId);
        for (int i = 0; i < orderDetails.size(); i++) {
            OrderDetail orderDetail = orderDetails.get(i);
            value += orderDetail.getWeight() * orderDetail.getPrice();
        }
        return value;
    }

}
