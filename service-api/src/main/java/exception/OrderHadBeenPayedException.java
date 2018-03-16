package exception;

public class OrderHadBeenPayedException extends RuntimeException {

    public OrderHadBeenPayedException() {
        super("订单已支付");
    }
}
