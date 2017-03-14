package core.job;

/**
 * Created by tctupangiu on 06/03/2017.
 */
public class JobException extends Exception {

    /**
     * Error creating the job
     */
    public static final int CREATE_EXCEPTION = 1000;

    /**
     * Error updating the job.
     */
    public static final int UPDATE_EXCEPTION = 1001;

    /**
     * Error deleting the job
     */
    public static final int DELETE_EXCEPTION = 1002;

    /**
     * Error deleting the job
     */
    public static final int EXECUTION_EXCEPTION = 1004;

    private Throwable cause=null;
    private int reason;

    public JobException() {
        super();
    }

    public JobException(int reason, String s) {
        super(s);
        this.reason = reason;
    }

    public JobException(String s, Throwable e) {
        super(s);
        this.cause=e;
    }

    @Override
    public String toString() {
        return getMessage();
    }

    @Override
    public Throwable getCause(){
        return this.cause;
    }

    public int getReason() {
        return reason;
    }
}
