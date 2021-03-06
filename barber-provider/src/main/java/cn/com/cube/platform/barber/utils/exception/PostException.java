package cn.com.cube.platform.barber.utils.exception;

import static org.slf4j.helpers.MessageFormatter.arrayFormat;

/**
 * @Author Liang.zhang
 * @Date 2017/12/8 15:56
 */
public class PostException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Long code;

    public PostException() {
    }

    /**
     * @param code error code
     */
    public PostException(Long code) {
        this.code = code;
    }

    /**
     * @param code error code
     * @param e exception
     */
    public PostException(Long code, Throwable e) {
        super(e);
        this.code = code;
    }

    /**
     * @param code error code
     * @param message error message
     * @param args error message args
     */
    public PostException(Long code, String message, Object ... args) {
        this(message, args);
        this.code = code;
    }

    /**
     * @param message error message
     * @param args error message args
     */
    public PostException(String message, Object ... args) {
        super(arrayFormat(message, args).getMessage(),
                arrayFormat(null, args).getThrowable());
    }

    /**
     * @return the code
     */
    public Long getCode() {
        return code;
    }

    /**
     * @param code the code
     * @return this
     */
    public PostException setCode(Long code) {
        this.code = code;
        return this;
    }


}
