package exception;

public class HousingEstateNotExistException extends RuntimeException {

    public HousingEstateNotExistException() {
        super("小区不存在");
    }
}
