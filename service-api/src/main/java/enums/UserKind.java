package enums;

public enum UserKind {
    CUSTOMER(0, "customer"), COLLECTOR(1, "collector"),
    COMPANY(2, "company");

    private int kind;
    private String kindInfo;

    UserKind(int kind, String kindInfo) {
        this.kind = kind;
        this.kindInfo = kindInfo;
    }

    public static int getKind(String kindInfo) {
        for(UserKind userKind : values()) {
            if (userKind.kindInfo.equals(kindInfo)) {
                return userKind.kind;
            }
        }
        return -1;
    }

    public static String getKindInfo(int kind) {
        for (UserKind userKind : values()) {
            if (userKind.kind == kind) {
                return userKind.kindInfo;
            }
        }
        return null;
    }
}
