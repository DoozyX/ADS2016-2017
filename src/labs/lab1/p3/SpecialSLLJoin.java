package labs.lab1.p3;

import labs.lab1.p2.SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
        Special join lists Problem 3
        Given two single linked lists with integer nodes, join them in a resulting single linked list in a way that alternatively adds at first the first two nodes from the first list,
         then the first two from the second, then next two from the first list, and then the second two from the second list, etc. The nodes that remain should be added at the end,
         at first from the first list, then the remaining from the second list.

        In the first line from the input the numbers from the first list are given, and in the second line the numbers from the second list.
        The numbers from the resulting list should be printed at the output.
*/

public class SpecialSLLJoin <E>{

    public static void main(String[] args) throws IOException{
        SLL<Integer> lista1 = new SLL<>();
        SLL<Integer> lista2 = new SLL<>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }

        s = stdin.readLine();
        N = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }
        SLL<Integer> spoeni = new SLL<>();
        spoeni = spoeni.specialJoin(lista1,lista2);
        System.out.println(spoeni.toString());
    }
}
