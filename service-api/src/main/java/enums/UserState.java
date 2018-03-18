package enums;

public enum UserState {
    NORMAL("正常"), FREEZE("冻结"), SEAL("封号");

    private String info;
    private static final int normalCredit = 300;
    private static final int freezeCredit = 200;
    private static final int sealCredit = 100;

    UserState(String info) {
        this.info = info;
    }

    public static UserState getUserState(int credit) {
        if (credit > normalCredit) {
            return NORMAL;
        } else if (credit > freezeCredit) {
            return FREEZE;
        } else {
            return SEAL;
        }
    }

    public String getInfo() {
        return this.info;
    }
}
