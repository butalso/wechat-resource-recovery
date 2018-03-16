package exception;

public class AddressNonExistsException extends RuntimeException {

    public AddressNonExistsException() {
        super("地址不存在");
    }
}
