package entity;

import java.util.Date;

public class OrderItem {
    private int id;
    private Date createTime;
    private Date finishTime;
    private int state;
    private int userId;
    private int collectorId;
    private int companyId;
    private int userGrade;
    private int collectorGrade;

    public OrderItem() {
    }

    public OrderItem(int id, Date finishTime, int state,
                     int collectorId, int companyId, int userGrade,
                     int collectorGrade) {
        this.id = id;
        this.finishTime = finishTime;
        this.state = state;
        this.collectorId = collectorId;
        this.companyId = companyId;
        this.userGrade = userGrade;
        this.collectorGrade = collectorGrade;
    }

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(int collectorId) {
        this.collectorId = collectorId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", finishTime=" + finishTime +
                ", state=" + state +
                ", userId=" + userId +
                ", collectorId=" + collectorId +
                ", companyId=" + companyId +
                ", userGrade=" + userGrade +
                ", collectorGrade=" + collectorGrade +
                '}';
    }
}
