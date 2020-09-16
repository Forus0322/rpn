package com.forus.rpn.exception;

/**
 * RPN计算器统一对外暴露异常
 */
public class RPNException extends Exception {

    private static final long serialVersionUID = -1936201988317224590L;

    public RPNException(String message) {
        super(message);
    }

}
