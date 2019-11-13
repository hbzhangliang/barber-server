package cn.com.cube.platform.barber.utils.resp;

public class BaseResponse<T> {
    private Long code=200L;
    private String message;
    private T data;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseResponse() {
    }

    public BaseResponse(String message) {
        this.message = message;
    }

    public BaseResponse(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public static BaseResponse error(Long code, String message){
        return new BaseResponse(code,message);
    }



}
