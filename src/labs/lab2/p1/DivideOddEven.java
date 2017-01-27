package labs.lab2.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideOddEven {
    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        stdin.close();
        String[] pomniza = s.split(" ");
        DLL<Integer> lista = new DLL<>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }
        DLL<Integer> evenList = lista.splitParity(true);
        DLL<Integer> oddList = lista.splitParity(false);
        System.out.println(oddList.toStringSpace());
        System.out.print(evenList.toStringSpace());
    }
}