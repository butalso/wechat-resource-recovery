package entity;

public class Manager extends User {
    private final int userKind = 3;

    @Override
    public int getUserKind() {
        return userKind;
    }
}
