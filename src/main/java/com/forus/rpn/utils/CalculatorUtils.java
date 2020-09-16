package com.forus.rpn.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 计算器工具类。
 */
public final class CalculatorUtils {

    //使用DecimalFormat调整输出结果格式
    private static final DecimalFormat FORMATOR = new DecimalFormat("##########.##########");
    static {
        //设置截取规则（不要四舍五入，直接截断）
        FORMATOR.setRoundingMode(RoundingMode.FLOOR);
    }

    private CalculatorUtils() {
    }

    public static boolean isNumber(String str) {
        return NumberUtils.isNumber(str);
    }

    /**
     * 通过计算精度的方式，判断输入数是否为整数
     * 
     * @param number
     * @return
     */
    public static boolean isInteger(double number) {
        //设置精度0.0000000001
        //如：1.0000000001不是整数
        //如：1.00000000009是整数
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
