package springdemo.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult(T data, String message) {// supere hem data hem mesaj döner
        super(data,true ,message);
    }
    public SuccessDataResult(T data){// data ve başarı bilgisi döner
        super(data,true);
    }
    public SuccessDataResult(String message){// sadece mesaj ve başarı bilgisi
        super(null,true,message);
    }
    public SuccessDataResult(){
        super(null,true);// sadece başarı bilgisi
    }
}
