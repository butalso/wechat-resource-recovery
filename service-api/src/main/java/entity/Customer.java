package entity;

import dto.Address;

/**
 * 业主实体（卖废品的用户）
 */
public class Customer extends User {
    private final Integer userKind = 0;
    private String gender;
    private Integer credit;
    private Integer point;
    private Integer experience;

    public Customer() {
    }

    public Customer(String name) {
        super(name);
    }

    public Customer(String name, String password, String phone, String gender, Address address) {
        super(name, password, phone, address);
        this.gender = gender;
    }

    public Customer(Customer customer) {
        this(customer.getName(), null, customer.getPhone(), customer.gender, null);
    }

    @Override
    public Integer getUserKind() {
        return userKind;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userKind=" + userKind +
                ", gender='" + gender + '\'' +
                ", credit=" + credit +
                ", point=" + point +
                ", experience=" + experience +
                '}';
    }
}
