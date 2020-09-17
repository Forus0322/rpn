package com.forus.rpn.calc;

public interface ClearOperator {

    /**
     * 清除栈所有数据
     * 
     * 需要注意的是，该操作不被undo操作回退
     */
    void clear();
}
