package exception;

public class OrderHadBeenReceivedException extends RuntimeException {
    public OrderHadBeenReceivedException() {
        super("已有回收员接单");
    }
}
