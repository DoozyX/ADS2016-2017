package labs.lab3.p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 Arithmetic expression Problem 1

 Given an arithmetic expression of the form (A+B) or (A-B) where A and B are also arithmetic expressions or digits (between 0 and 9), evaluate it.

 Sample input
 (1+2)

 Sample output
 3
 */

public class ArithmeticExpression {

    //function for evaluating the expression starting from
    // index l to index r
    static int presmetaj(char c[], int l, int r) {
        // Your code here
        ++l; --r;
        if (r-l == 2) {
            if (c[l+1] == '+') {
                return (c[l] - '0') + (c[r] - '0');
            } else if (c[l+1] == '-') {
                return (c[l] - '0') - (c[r] - '0');
            }else {
                return 0;
            }
        }
        int leftBrackets = 1, rightBrackets = 0;
        int i = l+1;
        while (leftBrackets != rightBrackets) {
            if (c[i] == '(') {
                ++leftBrackets;
            }
            if (c[i] == ')') {
                ++rightBrackets;
            }
            i++;
        }
        if (c[i] == '+') {
            return presmetaj(c, l, i-1) + presmetaj(c, i+1,r);
        } else if (c[i] == '-'){
            return presmetaj(c, l, i-1) - presmetaj(c, i+1,r);
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}
