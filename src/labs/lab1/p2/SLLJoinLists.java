package labs.lab1.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
        Join lists Problem 2
        For given two single linked lists with integers sorted in ascending order, join them in a sorted single linked list in ascending order. Duplicate nodes should be deleted.

        The first line in the input gives the first list node number, then in the second line there are the node numbers in the first list. The third line gives the second list node number,
        and in the end the forth line gives the numbers from the second list. The output prints the node numbers of the resulting list.

        Class (Java): SLLJoinLists

        Note: Create data structure single linked list and use it in this problem.
*/

public class SLLJoinLists {
    public static void main(String[] args) throws IOException {
        SLL<Integer> lista1 = new SLL<>();
        SLL<Integer> lista2 = new SLL<>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
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
        stdin.close();
        pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }

        SLL<Integer> spoeni;
        spoeni = lista1.joinLists(lista2);
        Iterator<Integer> it = spoeni.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            if(it.hasNext())
                System.out.print(" ");
        }
        System.out.println();

    }
}
