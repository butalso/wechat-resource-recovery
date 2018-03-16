package exception;

public class OrderHadBeenGradedException extends RuntimeException {
    public OrderHadBeenGradedException() {
        super("订单已评分");
    }
}
