package entity;

import java.io.Serializable;

public class Account implements Serializable {
    private String wechatId;
    private Double balance;

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "wechatId='" + wechatId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
