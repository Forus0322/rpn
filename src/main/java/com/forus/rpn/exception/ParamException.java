package com.forus.rpn.exception;

/**
 * 参数异常
 * 当操作参数不合法时抛出该异常（如分母为0）
 */
public class ParamException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -6329594365677797742L;

    public ParamException(String message) {
        super(message);
    }

}
