package springdemo.northwind.core.utilities.results;

public class DataResult <T> extends Result{ // data veri tipi farklı olabileceğinden T generic parametresi verildi
    private T data;
    public DataResult(T data ,boolean success, String message) {
        super(success, message);// base sınıfın const çalıştırmaya yarar
        this.data = data;
    }
    public DataResult(T data ,boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
