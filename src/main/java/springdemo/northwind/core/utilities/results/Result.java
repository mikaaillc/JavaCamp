package springdemo.northwind.core.utilities.results;

public class Result {// super type

    private String message;
    private boolean success;

    public Result(boolean success, String message) {
        this(success);// tek parametreli contructor çağrılır
        this.message = message;
    }

    public Result(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

}
