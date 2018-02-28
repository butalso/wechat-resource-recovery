package exception;

public class LackOfBalanceException extends RuntimeException {

    public LackOfBalanceException() {
        super("账户余额不足");
    }
}
