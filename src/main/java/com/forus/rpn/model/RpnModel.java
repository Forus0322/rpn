package com.forus.rpn.model;

import java.util.List;
import java.util.Stack;

import lombok.Data;

@Data
public class RpnModel {
    
    /**
     * 记录当前计算结果
     */
    private Stack<Double> numStack = new Stack<>();

    /**
     * 记录历史数据
     */
    private Stack<List<Double>> historyStack = new Stack<>();
}
