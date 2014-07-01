package botz;

/**
 * Created by schniz on 6/30/14.
 */
public class Pojo {
    private int number;
    private String string;
    private static String staticString;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getString() {
        return this.string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public static String getStaticString() {
        return Pojo.staticString;
    }

    public static void setStaticString(String string) {
        Pojo.staticString = string;
    }
}
