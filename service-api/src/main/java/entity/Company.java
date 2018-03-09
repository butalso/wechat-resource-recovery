package entity;

import dto.Address;

/**
 * 企业实体
 */
public class Company extends User {
    private final int userKind = 2;

    public Company() {
    }

    public Company(String name) {
        super(name);
    }

    public Company(String name, String password,
                   String phone, Address address) {
        super(name, password, phone, address);
    }

    public Integer getUserKind() {
        return userKind;
    }

    @Override
    public String toString() {
        return "Company{" +
                super.toString() +
                "userKind=" + userKind +
                '}';
    }
}
