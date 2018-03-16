package exception;

public class UserNonExistsException extends RuntimeException {
    public UserNonExistsException() {
        super("用户不存在");
    }
}
