package com.calculator.components;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionEvaluator {

    public static double evaluateExpression(String expression) {

        Deque<Double> values = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        char[] token = expression.toCharArray();

        for (int i = 0; i < token.length; i++) {

            if (token[i] == ' ') {
                continue;
            }

            if (token[i] >= '0' && token[i] <= '9') {
                StringBuilder stringBuilder = new StringBuilder();

                while (i < token.length && ((token[i] >= '0' && token[i] <= '9') || token[i] == '.')) {
                    stringBuilder.append(token[i++]);
                }
                values.push(Double.parseDouble(stringBuilder.toString()));
                i--;
            } else if (token[i] == '(') {
                ops.push(token[i]);
            } else if (token[i] == ')') {

                while (ops.peek() != '(') {
                    values.push(applyOperand(ops.pop(), values.pop(), values.pop()));
                }

                ops.pop();
            } else if (token[i] == '+' || token[i] == '-' || token[i] == '*' || token[i] == '/') {
                while (!ops.isEmpty() && hasPrecedence(token[i], ops.peek())) {
                    values.push(applyOperand(ops.pop(), values.pop(), values.pop()));
                }

                ops.push(token[i]);
            }

        }

        while (!ops.isEmpty()) {
            values.push(applyOperand(ops.pop(),values.pop(),values.pop()));
        }
        return values.pop();
    }

    public static Double applyOperand(Character op,double a,double b) {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0.00;
    }

    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
            (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
}
