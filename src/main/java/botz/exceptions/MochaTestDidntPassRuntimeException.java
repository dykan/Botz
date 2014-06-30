package botz.exceptions;

/**
 * Created by schniz on 6/30/14.
 */
public class MochaTestDidntPassRuntimeException extends RuntimeException {
    public MochaTestDidntPassRuntimeException(String s) {
        super(s);
    }
}
