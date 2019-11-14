package cn.com.cube.platform.barber.utils.resp;


/**
 * @Author Liang.zhang
 * @Date 2017/12/19 10:44
 */
public class PoseBaseResponse<T> extends BaseResponse<T> {

    public PoseBaseResponse(String message) {
        super(message);
    }

    public static <W> BaseResponse<W> error(String message) {
        return BaseResponse.error(-4001L, message);
    }

    public static BaseResponse success(String message) {
        return new BaseResponse(message);
    }

    public static <T> BaseResponse success(String message, T data) {
        return new BaseResponse<T>(message, data);
    }

    public static <T> BaseResponse successData(T data) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(data);
        return baseResponse;
    }

    //token非法
    public static  <W> BaseResponse<W> errorIllegalToken() {
        return BaseResponse.error(-50008L, "Illegal token");
    }

    public static  <W> BaseResponse<W> errorOtherLoginIn() {
        return BaseResponse.error(-50012L, "Other clients logged in");
    }

    public static  <W> BaseResponse<W> errorTokenExpired() {
        return BaseResponse.error(-50014L, "Token expired");
    }

}
