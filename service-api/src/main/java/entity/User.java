package entity;

import dto.Address;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统的使用者，Customer和Collector和Company和manager的父类
 */

public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private String imageUrl;
    private String phone;
    private Address address;
    private Date createTime;
    private int userKind;

    public User() {
    }

    public User(Integer id, String name, Integer userKind) {
        this.id = id;
        this.name = name;
        this.userKind = userKind;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getUserKind() {
        return userKind;
    }

    public void setUserKind(int userKind) {
        this.userKind = userKind;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", createTime=" + createTime +
                '}';
    }

}
