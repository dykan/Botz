package botz.util;

/**
 * Created by schniz on 6/30/14.
 */
public class ProcMon implements Runnable {
    private Process process;
    private volatile boolean completed;

    @Override
    public void run() {
        try {
            process.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        completed = true;
    }

    public ProcMon(Process process) {
        this.process = process;
        this.completed = false;
    }

    public static ProcMon create(Process proc) {
        ProcMon procMon = new ProcMon(proc);
        Thread t = new Thread(procMon);
        t.start();
        return procMon;
    }

    public boolean isAlive() {
        return !completed;
    }
}
