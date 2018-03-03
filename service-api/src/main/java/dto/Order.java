package dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import entity.Garbage;
import entity.OrderDetail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order implements Serializable {

    private int id;
    private Address address;
    private Date createTime;
    private Date finishTime;
    private String stateInfo;
    private String customerName;
    private String collectorName;
    private String companyName;
    private int userGrade;
    private int collectorGrade;
    /* 订单详情，废品到重量的映射 */
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address=" + address +
                ", createTime=" + createTime +
                ", finishTime=" + finishTime +
                ", stateInfo='" + stateInfo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", collectorName='" + collectorName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", userGrade=" + userGrade +
                ", collectorGrade=" + collectorGrade +
                ", list=" + orderDetails +
                '}';
    }
}
