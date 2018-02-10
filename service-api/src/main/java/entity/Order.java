package entity;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Date createTime;
    private Date finishTime;
    private String stateInfo;
    private String customer;
    private String collector;
    private String company;
    private int customerGrade;
    private int collectorGrade;
    private List<OrderDetail> orderDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(int customerGrade) {
        this.customerGrade = customerGrade;
    }

    public int getCollectorGrade() {
        return collectorGrade;
    }

    public void setCollectorGrade(int collectorGrade) {
        this.collectorGrade = collectorGrade;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
