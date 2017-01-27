package exams.first.exercise.p7;


import java.io.IOException;
import java.util.Scanner;

/**
 Букви Problem 7 (0 / 0)
 Дадена е низа од големи букви, во која буквата S се појавува парен број пати. После секоја буква S буквата Т се појавува еднаш или повеќе пати.
 Користејќи стек да се одреди дали после секоја буква S (до следната буква S), буквата Т се појавува ист број на пати.
 На првиот ред од влезот се чита низа од карактери (стринг), на излез се печати 1 доколку буквата Т се појавува ист број на пати после секоја S, и нула доколку овој услов не е исполнет.
 */

public class StackBukvi {
    static int proveri_t_posle_s(char[] St) {
        // Vasiot kod tuka
        int n = St.length;
        Stack<Character> stack = new ArrayStack<>(n);
        boolean first = true;
        boolean inInterval = false;
        int len=0, count;
        boolean firstInteerval = true;
        for ( char c : St ) {
            if (c == 'S' && first) {
                first = false;
                inInterval = true;

            } else if (c == 'S') {
                count = 0;
                while (!stack.isEmpty()) {
                    stack.pop();
                    ++count;
                }
                if (firstInteerval) {
                    len = count;
                    firstInteerval = false;
                }
                if (count != len) {
                    return 0;
                }
             } else if (c == 'T' && inInterval) {
                stack.push(c);
            }
        }
        count = 0;
        while (!stack.isEmpty()) {
            stack.pop();
            ++count;
        }
        if (count != len) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        char[] niza = new char[100];

        Scanner f = new Scanner(System.in);
        String st = f.next();
        niza = st.toCharArray();

        int rez = proveri_t_posle_s(niza);
        System.out.println(rez);
    }
}

