package exception;

public class OrderNonConfirmedException extends RuntimeException {
    public OrderNonConfirmedException() {
        super("订单未完成");
    }
}
