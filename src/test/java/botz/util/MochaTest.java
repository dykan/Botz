package botz.util;

import botz.exceptions.MochaTestDidntPassRuntimeException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by schniz on 6/30/14.
 */
public class MochaTest {
    String path = null;

    public MochaTest(String path) {
        this.path = path;
    }

    public void run() throws IOException {
        Process process = Runtime.getRuntime().exec("mocha " + path);
        String s = getErrors(process);

        if (!s.isEmpty()) {
            throw new MochaTestDidntPassRuntimeException(s);
        }
    }

    private String getErrors(Process process) throws IOException {
        String s = "";

        ProcMon procMon = ProcMon.create(process);
        InputStream errorStream = process.getErrorStream();
        double available = errorStream.available();

        while (procMon.isAlive() || available > 0) {
            byte[] bytes = new byte[(int) available];
            errorStream.read(bytes);

            s += new String(bytes);
            available = errorStream.available();
        }
        return s;
    }
}
