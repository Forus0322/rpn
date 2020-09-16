package com.forus.rpn.calc;

/**
 * 通用计算器接口
 * 定义计算器基本操作
 */
public interface ICalculator {
    
    double addition(double n, double m);

    double subtraction(double n, double m);

    double multiplication(double n, double m);

    double division(double n, double m);

    double sqrt(double n);
}
