package exams.first.exercise.p1;

import labs.lab2.p1.DLL;
import labs.lab2.p1.DLLNode;
import java.util.Scanner;

/**
* Дадена е двојно поврзана листа со N јазли каде секој јазел содржи по еден карактер (буква).
* Да се провери дали двојно поврзаната листа е палиндром: односно ако ја изминете од почеток до крај и од крај до почеток, дали ќе добиете ист збор.
* Во првиот ред од влезот даден е бројот на јазли во листата N, а во вториот ред се дадени броевите. На излез треба да се испечати 1 ако листата е палиндром, -1 ако не е.
*/


public class PalindromeDLL {
    public static int isItPalindrome(DLL<Integer> list) {
        //Vashiot kod tuka..
        int n = list.length();
        if (list.getFirst() != null) {
            DLLNode<Integer> tmpFirst = list.getFirst();
            DLLNode<Integer> tmpLast = list.getLast();
            String firstHalf = "";
            String lastHalf = "";
            for (int i = 0; i < n/2; ++i) {
                firstHalf += Integer.toString(tmpFirst.getElement());
                lastHalf += Integer.toString(tmpLast.getElement());
                tmpFirst = tmpFirst.getSucc();
                tmpLast = tmpLast.getPred();
            }
            if (firstHalf.equals(lastHalf)) {
                return 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isItPalindrome(list));
    }

}
