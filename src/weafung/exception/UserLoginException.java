package weafung.exception;

public class UserLoginException extends RuntimeException {
    public UserLoginException() {
        super("Login faild");
    }
    public UserLoginException(String msg) {
        super(msg);
    }
}
