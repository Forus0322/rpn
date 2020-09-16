package com.forus.rpn.calc.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.forus.rpn.calc.RPNOperator;
import com.forus.rpn.exception.RPNException;

import org.junit.jupiter.api.Test;

public class RPNCalculatorImplTest {

    @Test
    void testExample1() throws RPNException {
        String expression = "5 2";

        RPNOperator calculator = CalculatorFactory.getInstance().createRPNCalculator();
        calculator.calcRpn(expression);

        String result = calculator.result();
        assertEquals(result.trim(), "5 2");
    }

    @Test
    void testExample2() throws RPNException {
        String expression = "2 sqrt";

        RPNOperator calculator = CalculatorFactory.getInstance().createRPNCalculator();
        calculator.calcRpn(expression);

        String result = calculator.result();
        assertEquals(result.trim(), "1.4142135623");

        // ------------split------------

        expression = "clear 9 sqrt";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "3");
    }

    @Test
    void testExample3() throws RPNException {
        String expression = "5 2 -";

        RPNOperator calculator = CalculatorFactory.getInstance().createRPNCalculator();
        calculator.calcRpn(expression);

        String result = calculator.result();
        assertEquals(result.trim(), "3");

        // ------------split------------

        expression = "3 -";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "0");

        // ------------split------------

        expression = "clear";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "");
    }

    @Test
    void testExample4() throws RPNException {
        String expression = "5 4 3 2";

        RPNOperator calculator = CalculatorFactory.getInstance().createRPNCalculator();
        calculator.calcRpn(expression);

        String result = calculator.result();
        assertEquals(result.trim(), "5 4 3 2");

        // ------------split------------

        expression = "undo undo *";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "20");

        // ------------split------------

        expression = "5 *";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "100");

        // ------------split------------

        expression = "undo";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "20 5");
    }

    @Test
    void testExample5() throws RPNException {
        String expression = "7 12 2 /";

        RPNOperator calculator = CalculatorFactory.getInstance().createRPNCalculator();
        calculator.calcRpn(expression);

        String result = calculator.result();
        assertEquals(result.trim(), "7 6");

        // ------------split------------

        expression = "*";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "42");

        // ------------split------------

        expression = "4 /";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "10.5");
    }

    @Test
    void testExample6() throws RPNException {
        String expression = "1 2 3 4 5";

        RPNOperator calculator = CalculatorFactory.getInstance().createRPNCalculator();
        calculator.calcRpn(expression);

        String result = calculator.result();
        assertEquals(result.trim(), "1 2 3 4 5");

        // ------------split------------

        expression = "*";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "1 2 3 20");

        // ------------split------------

        expression = "clear 3 4 -";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "-1");
    }

    @Test
    void testExample7() throws RPNException {
        String expression = "1 2 3 4 5";

        RPNOperator calculator = CalculatorFactory.getInstance().createRPNCalculator();
        calculator.calcRpn(expression);

        String result = calculator.result();
        assertEquals(result.trim(), "1 2 3 4 5");

        // ------------split------------

        expression = "* * * *";
        calculator.calcRpn(expression);

        result = calculator.result();
        assertEquals(result.trim(), "120");
    }

    @Test
    void testExample8() {
        String expression = "1 2 3 * 5 + * * 6 5";

        RPNOperator calculator = CalculatorFactory.getInstance().createRPNCalculator();
        try {
            calculator.calcRpn(expression);
        } catch (RPNException e) {
            assertEquals(e.getMessage().trim(), "Operator * (position: 7): insucient parameters");
        }

        String result = calculator.result();
        assertEquals(result.trim(), "11");
    }
}
