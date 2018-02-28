package exception;

public class FormatErrorException extends RuntimeException {

    public FormatErrorException() {
        super("格式错误或信息不全");
    }
}
