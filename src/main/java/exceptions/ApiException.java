package exceptions;

public class ApiException extends RuntimeException {
    private final int status;


    public ApiException(int status,String msg) {
        super(msg);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
