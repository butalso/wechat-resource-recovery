package exception;

public class DelOrderFailException extends RuntimeException {
    public DelOrderFailException() {
        super("订单删除失败");
    }
}
