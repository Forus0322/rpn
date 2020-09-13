package com.forus.rpn.calc.impl;

import java.util.Collections;
import java.util.List;

import com.forus.rpn.calc.ICalculator;
import com.forus.rpn.calc.IRPNCalculator;
import com.forus.rpn.exception.OperatorException;
import com.forus.rpn.exception.ParamException;
import com.forus.rpn.exception.RPNException;
import com.forus.rpn.model.RpnModel;
import com.forus.rpn.utils.CalculatorUtils;
import com.forus.rpn.utils.Constants;
import com.google.common.collect.Lists;

/**
 * RPN计算器实现类，不对外暴露
 * 仅通过IRPNCalculator使用
 */
class RPNCalculatorImpl implements IRPNCalculator, ICalculator {

    private RpnModel model = new RpnModel();

    @Override
    public double addition(double n, double m) {
        return n + m;
    }

    private void addition() throws OperatorException {
        if (model.getNumStack().size() > 1) {
            double m = model.getNumStack().pop();
            double n = model.getNumStack().pop();

            double r = this.addition(n, m);
            model.getNumStack().add(r);

            logHistory(n, m);
        } else {
            throw new OperatorException("+");
        }
    }

    @Override
    public double subtraction(double n, double m) {
        return n - m;
    }

    private void subtraction() throws OperatorException {
        if (model.getNumStack().size() > 1) {
            double m = model.getNumStack().pop();
            double n = model.getNumStack().pop();

            double r = this.subtraction(n, m);
            model.getNumStack().add(r);

            logHistory(n, m);
        } else {
            throw new OperatorException("-");
        }
    }

    @Override
    public double multiplication(double n, double m) {
        return n * m;
    }

    private void multiplication() throws OperatorException {
        if (model.getNumStack().size() > 1) {
            double m = model.getNumStack().pop();
            double n = model.getNumStack().pop();

            double r = this.multiplication(n, m);
            model.getNumStack().add(r);

            logHistory(n, m);
        } else {
            throw new OperatorException("*");
        }
    }

    @Override
    public double division(double n, double m) {
        return n / m;
    }

    private void division() throws OperatorException, ParamException {
        if (model.getNumStack().size() > 1) {
            double m = model.getNumStack().pop();
            double n = model.getNumStack().pop();

            if (m != 0) {
                double r = this.division(n, m);
                model.getNumStack().add(r);
                logHistory(n, m);
            } else {
                throw new ParamException("The denominator can't be 0.");
            }
        } else {
            throw new OperatorException("/");
        }
    }

    @Override
    public double sqrt(double n) {
        return Math.sqrt(n);
    }

    private void sqrt() throws OperatorException {
        if (model.getNumStack().size() > 0) {
            double n = model.getNumStack().pop();
            double r = sqrt(n);
            model.getNumStack().add(r);

            logHistory(n);
        } else {
            throw new OperatorException("sqrt");
        }
    }

    @Override
    public void calcRpn(String expression) throws RPNException {
        String[] characters = expression.split("\\s+");

        int position = 0;
        for (String character : characters) {
            if (CalculatorUtils.isNumber(character)) {
                double number = Double.parseDouble(character);
                model.getNumStack().add(number);
            } else {
                try {
                    calc(character);
                } catch (OperatorException e) {
                    String operator = e.getMessage();
                    throw new RPNException(
                            "Operator " + operator + " (position: " + position + "): insucient parameters");
                } catch (ParamException e) {
                    throw new RPNException(e.getMessage());
                }
            }
            position++;
        }
    }

    @Override
    public void undo() {
        if (model.getNumStack().size() > 0) {
            model.getNumStack().pop();
            if (model.getHistoryStack().size() > 0) {
                List<Double> last = model.getHistoryStack().pop();
                // Collections.reverse(last);
                model.getNumStack().addAll(last);
            }
        }
    }

    @Override
    public void clear() {
        model.getNumStack().clear();
        model.getHistoryStack().clear();
    }

    @Override
    public String result() {
        return CalculatorUtils.display(model.getNumStack());
    }

    private void calc(String operator) throws OperatorException, ParamException {
        switch (operator) {
            case Constants.Operator.ADDITION:
                addition();
                break;
            case Constants.Operator.SUBTRACTION:
                subtraction();
                break;
            case Constants.Operator.MULTIPLICATION:
                multiplication();
                break;
            case Constants.Operator.DIVISION:
                division();
                break;
            case Constants.Operator.SQRT:
                sqrt();
                break;
            case Constants.Operator.UNDO:
                undo();
                break;
            case Constants.Operator.CLEAR:
                clear();
                break;
            default:
                break;
        }
    }

    private void logHistory(Double... numbers) {
        List<Double> history = Lists.newArrayList();
        Collections.addAll(history, numbers);
        model.getHistoryStack().add(history);
    }
}
