package com.forus.rpn.calc;

import com.forus.rpn.exception.RPNException;

/**
 * RPN计算器抽象类 定义计算器基本操作
 */
public interface RPNCalculator extends UndoOperator, ClearOperator {

    /**
     * 计算RPN表达式
     * 
     * @param expression
     * @throws RPNException
     */
    void calcRpn(String expression) throws RPNException;

    /**
     * 返回当前栈元素
     * 
     * @return
     */
    String result();
}
