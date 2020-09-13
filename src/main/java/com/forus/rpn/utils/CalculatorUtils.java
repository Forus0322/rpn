package com.forus.rpn.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 计算器工具类。
 */
public final class CalculatorUtils {

    private static final DecimalFormat FORMATOR = new DecimalFormat("##########.##########");
    static {
        FORMATOR.setRoundingMode(RoundingMode.FLOOR);
    }

    private CalculatorUtils() {
    }

    public static boolean isNumber(String str) {
        return NumberUtils.isNumber(str);
    }

    public static boolean isInteger(double number) {
        double precision = Math.pow(10, -10);
        return number - Math.floor(number) < precision;
    }

    public static String display(Stack<Double> numbers) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Double number : numbers) {
            if (isInteger(number)) {
                stringBuffer.append((int) number.doubleValue()).append(" ");
            } else {
                stringBuffer.append(FORMATOR.format(number)).append(" ");
                // stringBuffer.append(number);
            }

        }
        return stringBuffer.toString();
    }

}
