package com.forus.rpn.exception;

/**
 * 操作符未定义异常
 * 
 * 如出现未定义的操作符(如'_')
 */
public class OperationUndefinedException extends Exception {

    private static final long serialVersionUID = 1155372345301058580L;

    public OperationUndefinedException(String message) {
        super(message);
    }

}
