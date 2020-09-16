package com.forus.rpn.calc;

import com.forus.rpn.exception.RPNException;
import com.forus.rpn.model.RpnModel;

/**
 * RPN计算器抽象类
 * 定义计算器基本操作
 */
public abstract class RPNOperator {
    
    protected RpnModel model = new RpnModel();

    /**
     * 计算RPN表达式
     * 
     * @param expression
     * @throws RPNException
     */
    public abstract void calcRpn(String expression) throws RPNException;

    /**
     * 回退上一步操作
     */
    public abstract void undo();

    /**
     * 清除栈所有数据
     * 
     * 需要注意的是，该操作不被undo操作回退
     */
    public abstract void clear();

    /**
     * 返回当前栈元素
     * 
     * @return
     */
    public abstract String result();
}
