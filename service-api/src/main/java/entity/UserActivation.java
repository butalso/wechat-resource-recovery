package entity;

import java.util.Date;

public class UserActivation {
    private Integer id;
    private Integer userId;
    private Integer userKind;
    private String date;
    private Date lastLoginTime;
    private Integer duration;

    public UserActivation() {
    }

    public UserActivation(Integer userId, Integer userKind,
                          String date, Date lastLoginTime,
                          Integer duration) {
        this.userId = userId;
        this.userKind = userKind;
        this.date = date;
        this.lastLoginTime = lastLoginTime;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserKind() {
        return userKind;
    }

    public void setUserKind(Integer userKind) {
        this.userKind = userKind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "UserActivation{" +
                "id=" + id +
                ", userId=" + userId +
                ", userKind=" + userKind +
                ", date=" + date +
                ", lastLoginTime=" + lastLoginTime +
                ", duration=" + duration +
                '}';
    }
}
