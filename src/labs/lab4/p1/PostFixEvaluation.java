package labs.lab4.p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 Postfix notation Problem 1
 Write an algorithm that evaluates an expression in postfix notation. The input is an array of expression characters (String). The output prints the value of the expression after it is evaluated.

 Sample input
 1 2 +

 Sample output
 3
 */
public class PostFixEvaluation {
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    static int evaluatePostfix(char [] izraz, int n)
    {
        // Your code here
        ArrayStack<Integer> stack = new ArrayStack<>(n);
        String temp = new String(izraz);
        String[] postfix = temp.split("\\s+");
        n = postfix.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (isNumeric(postfix[i])) {
                stack.push(Integer.parseInt(postfix[i]));
            } else if (postfix[i].equals( "*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (postfix[i].equals( "+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (postfix[i].equals( "-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if (postfix[i].equals( "/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = evaluatePostfix(exp, exp.length);
        System.out.println(rez);

        br.close();

    }
}