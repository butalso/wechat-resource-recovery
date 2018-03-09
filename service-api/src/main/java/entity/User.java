package entity;

import dto.Address;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统的使用者，Customer和Collector和Company的父类
 */

public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private String image_url;
    private String phone;
    private Float balance;
    private Address address;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String password, String phone, Address address) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public Integer getUserKind() {
        return 0;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", image_url='" + image_url + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", address=" + address +
                '}';
    }
}
