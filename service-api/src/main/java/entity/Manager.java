package entity;

public class Manager extends User {
    private final Integer userKind = 3;

    @Override
    public Integer getUserKind() {
        return userKind;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                "userKind=" + userKind +
                '}';
    }
}
