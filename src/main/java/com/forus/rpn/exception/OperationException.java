package com.forus.rpn.exception;

/**
 * 表达式执行异常
 * 当某个操作符（如 '*')需要2个参数，但栈内参数小于2时，则抛出该异常
 */
public class OperationException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 4650202360608260478L;

    /**
     * 
     * @param message   操作符
     */
    public OperationException(String message) {
        super(message);
    }

}
