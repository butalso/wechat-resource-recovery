package entity;

import dto.Address;

/**
 * 企业实体
 */
public class Company extends User {
    private final int userKind = 2;
    private Wallet wallet;

    public Company() {
    }

    public Company(Integer id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Company(String name, String password) {
        super(name, password);
    }

    public Company(String name, String password,
                   String phone, Address address) {
        super(name, password);
        this.setPhone(phone);
        this.setAddress(address);
    }

    public int getUserKind() {
        return userKind;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Company{" +
                super.toString() +
                "userKind=" + userKind +
                ", wallet=" + wallet +
                '}';
    }
}
