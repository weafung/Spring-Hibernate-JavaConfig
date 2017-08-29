package weafung.exception;

public class UserRegisterException extends RuntimeException {
    public UserRegisterException() {
        super("Register faild");
    }
    public UserRegisterException(String msg) {
        super(msg);
    }
}
