package com.forus.rpn.model;

import java.util.List;
import java.util.Stack;

import lombok.Data;

@Data
public class RpnModel {
    
    /**
     * 记录输入栈元素，以及计算结果元素（当遇到操作符时）
     */
    private Stack<Double> numStack = new Stack<>();

    /**
     * 记录历史数据
     */
    private Stack<List<Double>> historyStack = new Stack<>();
}
