package entity;

import dto.Address;

import java.io.Serializable;
import java.util.Date;

public class OrderItem implements Serializable {
    private Integer id;
    private Date createTime;
    private Date finishTime;
    private Date collectFromTime;
    private Date collectEndTime;
    private String state;
    private String customerName;
    private String collectorName;
    private String companyName;
    private Address address;
    private Integer customerGrade;
    private Integer collectorGrade;

    public OrderItem() {
    }

    public OrderItem(String customerName, Address address, Date collectFromTime, Date collectEndTime) {
        this.customerName = customerName;
        this.address = address;
        this.collectFromTime = collectFromTime;
        this.collectEndTime = collectEndTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getCollectFromTime() {
        return collectFromTime;
    }

    public void setCollectFromTime(Date collectFromTime) {
        this.collectFromTime = collectFromTime;
    }

    public Date getCollectEndTime() {
        return collectEndTime;
    }

    public void setCollectEndTime(Date collectEndTime) {
        this.collectEndTime = collectEndTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(Integer customerGrade) {
        this.customerGrade = customerGrade;
    }

    public Integer getCollectorGrade() {
        return collectorGrade;
    }

    public void setCollectorGrade(Integer collectorGrade) {
        this.collectorGrade = collectorGrade;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", finishTime=" + finishTime +
                ", collectFromTime=" + collectFromTime +
                ", collectEndTime=" + collectEndTime +
                ", state='" + state + '\'' +
                ", customerName='" + customerName + '\'' +
                ", collectorName='" + collectorName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address=" + address +
                ", customerGrade=" + customerGrade +
                ", collectorGrade=" + collectorGrade +
                '}';
    }
}
