package exception;

public class PasswordErrorException extends RuntimeException {
    public PasswordErrorException() {
        super("密码错误");
    }
}
