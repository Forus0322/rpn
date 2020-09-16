package com.forus.rpn.calc;

import com.forus.rpn.exception.RPNException;

/**
 * 定义PRN计算器基本操作
 */
public interface IRPNCalculator {

    void calcRpn(String expression) throws RPNException;

    void undo();

    void clear();

    String result();
}
