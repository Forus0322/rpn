package com.forus.rpn;

import java.util.Scanner;

import com.forus.rpn.calc.IRPNCalculator;
import com.forus.rpn.calc.impl.CalculatorFactory;
import com.forus.rpn.exception.RPNException;

public final class App {

    private App() {

        IRPNCalculator calculator = CalculatorFactory.getInstance().createRPNCalculator();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (true && flag) {
            System.out.println("Please enter rpn expression(Input 'quit' to end the program):");
            String expression = scanner.nextLine();
            if ("quit".equals(expression))
                break;
            try {
                calculator.calcRpn(expression);
            } catch (RPNException e) {
                System.out.println(e.getMessage());
                flag = false;
            }
            System.out.print("Stack: ");
            System.out.println(calculator.result());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new App();
    }
}
