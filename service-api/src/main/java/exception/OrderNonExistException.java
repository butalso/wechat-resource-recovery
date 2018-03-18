package exception;

public class OrderNonExistException extends RuntimeException {
    public OrderNonExistException() {
        super("订单不存在");
    }
}
