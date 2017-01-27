package exams.first.exercise.p3;

import labs.lab2.p1.DLL;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
     Листа од листи Problem 3 (0 / 0)
     Дадена е двојно поврзана листа од двојно поврзани листи. Да се најде сума на секоја од подлистите, а потоа производ на овие суми

     Влез: Број N кој кажува колку листи има Број М кој кажува колку елементи има во секоја листа Во следните М линии се податоците 1<=A<=1000за секоја од листите

     Излез: Еден број што е производот на сумите од низите. Со седум децимали.

     Пример влез: 3 4 1 2 3 4 2 3 4 5 6 7 8 9

     Sample input
     4
     4
     6 13 16 7
     7 23 9 11
     8 0 8 19
     6 6 9 11
     Sample output
     2352000
 */

public class ListaOdListi {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        int len = list.length();
        long[] sums = new long[len];
        for (int i = 0; i < len; ++i) {
            int lenSub = list.getLast().getElement().length();
            DLL<Integer> temp = list.getLast().getElement();
            for (int j = 0; j < lenSub; ++j) {
                sums[i] += temp.getLast().getElement();
                temp.deleteLast();
            }
            list.deleteLast();
        }
        return Arrays.stream(sums).reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }
}
