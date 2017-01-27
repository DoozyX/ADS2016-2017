package exams.first.exercise.p8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 Математички израз Problem 8
 Да се напише алгоритам кој ќе пресметува (евалуира) математички израз составен од броеви и операциите за собирање (+) и множење (*).

 Забелешка: Операцијата множење има предност пред операцијата собирање.

 Име на класата: ExpressionEvaluator

 Sample input
 2+2*2*2*2*2*2+2*2

 Sample output
 70
 */

public class ExpressionEvaluator {
    static int getN(String s, int l, int n) {
        String num = "";
        while (l < n && (s.charAt(l) != '+' && s.charAt(l) != '*')) {
            num += s.charAt(l);
            ++l;
        }
        return Integer.parseInt(num);
    }

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka
        Stack<Integer> expStack = new Stack<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            if (expression.charAt(i) == '+') {
                if (expStack.size() > 1) {
                    int a = expStack.pop();
                    int b = expStack.pop();
                    expStack.push(a+b);
                } else {
                    int num = getN(expression,i+1, n);
                    int numLen = (int)(Math.log10(num)+1);
                    i+= numLen;
                    expStack.push(num);
                }
            } else if (expression.charAt(i) == '*') {
                int num = getN(expression,i+1, n);
                int numLen = (int)(Math.log10(num)+1);
                i+= numLen;
                int a = expStack.pop();
                expStack.push(num * a);
            }else {
                int num = getN(expression,i, n);
                int numLen = (int)(Math.log10(num)+1);
                i+= numLen-1;
                expStack.push(num);
            }
        }
        if (expStack.size() > 1) {
            int a = expStack.pop();
            int b = expStack.pop();
            return a+b;
        }else {
            return expStack.pop();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}