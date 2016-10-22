package labs.lab1.p3;
import labs.lab1.p2.SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
