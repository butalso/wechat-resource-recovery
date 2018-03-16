package exception;

public class OrderOwnerException extends RuntimeException {
    public OrderOwnerException() {
        super("订单不属于该用户");
    }
}
