package entity;

public class Wallet {
    private Integer id;
    private Integer userId;
    private Integer userKind;
    private Double balance;
    private String payPassword;

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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", userId=" + userId +
                ", userKind=" + userKind +
                ", balance=" + balance +
                ", payPassword='" + payPassword + '\'' +
                '}';
    }
}
