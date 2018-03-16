package serviceImpl;

import dao.*;
import dto.Address;
import dto.Order;
import entity.*;
import enums.OrderState;
import exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.OrderService;
import util.Md5Util;
import util.OrderUtil;

import java.util.*;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class OrderServiceImpl implements OrderService {
    private final Double drawPercentage = 0.1d;

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private WalletDao walletDao;
    @Autowired
    private AddressDao addressDao;

    @Override
    public void addOrder(Order order)
            throws UserNonExistsException, AddressNonExistsException {
        Customer customer = userDao.getCustomer(order.getOrderItem().getCustomerName());
        Address address = order.getOrderItem().getAddress();

        if (customer == null) {
            throw new UserNonExistsException();
        }
        if (addressDao.getAddrDetailId(address.getDetail(), address.getArea()) == null) {
            throw new AddressNonExistsException();
        }
        OrderItem orderItem = order.getOrderItem();
        orderDao.addOrderItem(orderItem);
        orderDao.addOrderDetails(orderItem.getId(), order.getOrderDetails());
        // TODO: 用户创建订单成功，通知相关回收员算法
    }

    @Override
    public List<Order> getOrders(String name, int userKind) {
        List<OrderItem> orderItems = null;

        switch (userKind) {
            case 0: orderItems = orderDao.getCustomerOrderItems(name);
                    break;
            case 1: orderItems = orderDao.getCollectorOrderItems(name);
                    break;
            case 2: orderItems = orderDao.getCompanyOrderItems(name);
        }

        return getOrders(orderItems);
    }

    @Override
    public List<Order> getNewOrders(String name) {
        List<OrderItem> orderItems = orderDao.getNewOrderItems(name);
        return getOrders(orderItems);
    }

    /**
     * 根据订单项组装订单
     * @param orderItems
     * @return
     */
    private List<Order> getOrders(List<OrderItem> orderItems) {
        List<Order> result = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            Order order = new Order();
            List<OrderDetail> orderDetails = orderDao.getOrderDetails(orderItem.getId());

            order.setOrderItem(orderItem);
            order.setOrderDetails(orderDetails);
            result.add(order);
        }
        return result;
    }

    @Override
    public void delUnfinishOrder(String name, int orderItemId) throws DelOrderFailException {
        if (orderDao.deleteOrderItem(orderItemId, name) == 1) {
            // TODO 信誉积分扣除算法
            orderDao.deleteOrderDetails(orderItemId);
            return;
        }
        throw new DelOrderFailException();
    }

    @Override
    public void receiveOrder(String name, int orderItemId) throws OrderHadBeenReceivedException {
        if (orderDao.receiveOrder(orderItemId, name) == 0) {
            throw new OrderHadBeenReceivedException();
        }
    }

    @Override
    @Transactional
    public void confirmOrderReceive(String name, int orderItemId)
            throws LackOfBalanceException, OrderOwnerException, OrderHadBeenPayedException {
        OrderItem orderItem = orderDao.getOrderItem(orderItemId);
        List<OrderDetail> orderDetails = orderDao.getOrderDetails(orderItemId);
        Order order = new Order(orderItem, orderDetails);

        if (orderItem.getState().equals(OrderState.COLLECT.getStateInfo())) {
            throw new OrderHadBeenPayedException();
        }
        if (!orderItem.getCollectorName().equals(name)) {
            throw new OrderOwnerException();
        }

        Customer customer = userDao.getCustomer(orderItem.getCustomerName());
        Company company = userDao.getCompany(orderItem.getCompanyName());
        Wallet customerWallet = walletDao.getWallet(customer.getId(), customer.getUserKind());
        Wallet companyWallet = walletDao.getWallet(company.getId(), company.getUserKind());

//        if (!Md5Util.getMD5(payPassword).equals(companyWallet.getPayPassword())) {
//            /*支付密码错误*/
//            throw new PasswordErrorException();
//        }
        double value = OrderUtil.calculateOrderValue(order);

        try {
            /*订单状态改变*/
            orderDao.collectorConfirmReceive(orderItemId, name);
            /*企业向用户转账*/
            transfer(companyWallet, customerWallet, value);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public void confirmOrderFinish(String name, int orderItemId, String payPassword)
            throws LackOfBalanceException, PasswordErrorException, OrderOwnerException, OrderHadBeenPayedException {
        OrderItem orderItem = orderDao.getOrderItem(orderItemId);
        List<OrderDetail> orderDetails = orderDao.getOrderDetails(orderItemId);
        Order order = new Order(orderItem, orderDetails);

        Collector collector = userDao.getCollector(orderItem.getCollectorName());
        Company company = userDao.getCompany(orderItem.getCompanyName());

        if (company != null && !name.equals(company.getName())) {
            /*不属于该企业的订单*/
            throw new OrderOwnerException();
        }
        if (orderItem.getState().equals(OrderState.FINISH.getStateInfo())) {
            /*订单已完成 */
            throw new OrderHadBeenPayedException();
        }

        Wallet collectorWallet = walletDao.getWallet(collector.getId(), collector.getUserKind());
        Wallet companyWallet = walletDao.getWallet(company.getId(), company.getUserKind());

        if (!Md5Util.getMD5(payPassword).equals(companyWallet.getPayPassword())) {
            /*支付密码错误*/
            throw new PasswordErrorException();
        }
        double value = OrderUtil.calculateOrderValue(order);

        try {
            /*订单状态改变*/
            orderDao.finishOrder(orderItemId, name);
            /*企业向回收员转账*/
            transfer(companyWallet, collectorWallet, value * drawPercentage);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    private void transfer(Wallet fromWallet, Wallet toWallet, double value)
            throws LackOfBalanceException {
        /*保留两位小数*/
        value = (double) Math.round(value * 100) / 100;
        /*回收员向用户转账*/
        int update = walletDao.updateWallet(fromWallet.getId(), fromWallet.getPayPassword(), -value);
        if (update <= 0) {
            throw new LackOfBalanceException();
        }
        walletDao.updateWallet(toWallet.getId(), toWallet.getPayPassword(), value);

    }

    @Override
    public void gradeOrder(Integer orderItemId, String name, int useKind, int grade)
            throws OrderNonConfirmedException, OrderHadBeenGradedException {
        OrderItem orderItem = orderDao.getOrderItem(orderItemId);

        List<OrderDetail> orderDetails = orderDao.getOrderDetails(orderItemId);
        Order order = new Order(orderItem, orderDetails);
        Customer customer = userDao.getCustomer(orderItem.getCustomerName());
        Collector collector = userDao.getCollector(orderItem.getCollectorName());

        if (OrderState.CREATE.getStateInfo().equals(orderItem.getState()) ||
                OrderState.RECEIVE.getStateInfo().equals(orderItem.getState())) {
            throw new OrderNonConfirmedException();
        }
        switch (useKind) {
            case 0: if (orderItem.getCustomerGrade() != 0) {
                        /*订单已评分*/
                        throw new OrderHadBeenGradedException();
                    }
                    orderDao.customerGradeOrder(orderItemId, grade, name);
                    /*回收员经验值、信誉值、积分值改变*/
                    updateUserECP(collector, OrderUtil.calculateOrderExperienceToCollector(order, grade),
                            OrderUtil.calculateOrderCreditToCollector(order, grade),
                            OrderUtil.calculateOrderPointToCollector(order, grade));
                    userDao.updateCollector(collector);
                    break;
            case 1: if (orderItem.getCollectorGrade() != 0) {
                        /*订单已评分*/
                        throw new OrderHadBeenGradedException();
                    }
                    orderDao.collectorGradeOrder(orderItemId, grade, name);
                    /*业主经验值、信誉值、积分值改变*/
                    updateUserECP(customer, OrderUtil.calculateOrderExperienceToCustomer(order, grade),
                            OrderUtil.calculateOrderCreditToCustomer(order, grade),
                            OrderUtil.calculateOrderPointToCustomer(order, grade));
                    userDao.updateCustomer(customer);
        }
    }

    private void updateUserECP(ECPUser user, int experience, int credit, int point) {
        user.setExperience(user.getExperience() + experience);
        user.setCredit(user.getCredit() + credit);
        user.setPoint(user.getPoint() + point);
    }
}
