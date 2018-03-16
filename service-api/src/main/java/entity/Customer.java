package entity;

import dto.Address;

/**
 * 业主实体（卖废品的用户）
 */
public class Customer extends ECPUser {
    private final int userKind = 0;

    public Customer() {
    }

    public Customer(String name, String password) {
        super(name, password);
    }

    public Customer(String name, String password, String gender
            , String phone, Address address) {
        super(name, password);
        this.setGender(gender);
        this.setPhone(phone);
        this.setAddress(address);
    }

    @Override
    public int getUserKind() {
        return userKind;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "userKind=" + userKind +
                '}';
    }

}
