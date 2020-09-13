package com.forus.rpn.calc.impl;

import com.forus.rpn.calc.IRPNCalculator;

/**
 * 通过工厂模式，获取RPN计算器实例
 */
public final class CalculatorFactory {

    private volatile static CalculatorFactory factory;

    public IRPNCalculator createRPNCalculator() {
        return new RPNCalculatorImpl();
    }

    private CalculatorFactory() {
    }

    public static CalculatorFactory getInstance() {
        if (factory == null) {
            synchronized (CalculatorFactory.class) {
                if (factory == null) {
                    factory = new CalculatorFactory();
                }
            }
        }

        return factory;
    }
}
