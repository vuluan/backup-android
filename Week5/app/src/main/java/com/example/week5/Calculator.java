package com.example.week5;

public class Calculator {

    enum Operator {
        add, subtract
    }

    public int operand1, operand2;
    public int result;

    public void performanceOperator(Operator operator, String num1, String num2) {

        if (strToInt(num1, 1) && strToInt(num2, 2)) {
            switch (operator) {
                case add:
                    result = operand1 + operand2;
                    break;
                case subtract:
                    result = operand1 - operand2;
                    break;
            }
        } else {
            operand1 = 0;
            operand2 = 0;
            result = 0;
        }
    }

    private boolean strToInt(String num, int operand) {
        try {
            if (operand == 1) {
                operand1 = Integer.parseInt(num);
            } else {
                operand2 = Integer.parseInt(num);
            }
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
