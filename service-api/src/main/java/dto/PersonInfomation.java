package dto;

import entity.Account;
import entity.User;

public class PersonInfomation {
    private User user;
    private Account account;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
