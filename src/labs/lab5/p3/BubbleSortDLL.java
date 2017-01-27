package labs.lab5.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Bubble sort on a linked list Problem 3 (0 / 0)
 You are given a doubly linked list with N nodes, where each node contains a single integer.
 You are supposed to sort this list using the bubble sort algorithm.

 In the first line of the input you will find a single integer N, representing the number of nodes in the list.
 In the second line of the input you will find the elements of the list with a single whitespace between them.

 The output should contain the final state of the array after the sorting is done.

 Note: You must use the data structure you've been given. You are not allowed to use arrays and similar data structures.
 */
public class BubbleSortDLL {

    public static void bubbleSort(DLL<Integer> lista){
        // Vasiot kod tuka
        boolean flag = true;
        while (flag) {
            DLLNode<Integer> tmp = lista.getFirst();
            flag= false;
            while (tmp.succ != null) {
                if (tmp.element > tmp.succ.element) {
                    int temp;
                    temp = tmp.element;
                    tmp.element = tmp.succ.element;
                    tmp.succ.element = temp;
                    flag = true;
                }
                tmp = tmp.succ;
            }
        }
        DLLNode<Integer> tmp = lista.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element);
            if(tmp.succ!=null)
                System.out.print(" ");
            tmp = tmp.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        bubbleSort(lista);

    }

}