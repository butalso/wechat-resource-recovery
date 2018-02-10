package enums;

public enum OrderState {
    CREATE(0, "订单已创建"), RECEIVE(1, "回收员已接单"), COLLECT(2, "回收员已回收"),
    FINISH(3, "订单完成");

    private int state;
    private String stateInfo;

    OrderState(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static OrderState stateOf(int state) {
        for(OrderState orderState: values()) {
            if (orderState.getState() == state) {
                return orderState;
            }
        }
        return null;
    }
}
