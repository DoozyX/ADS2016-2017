package exams.first.exercise.p2;

import labs.lab2.p1.DLL;
import labs.lab2.p1.DLLNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
     Војска Problem 2
     Пред командантот на војската наредени се сите војници и во двојно поврзана листа дадени се нивните ID-a.
     На командантот не му се допаѓа како се наредени војниците и решава да одбере два под-интервали од војници и да им ги замени местата,
     односно војниците што се наоѓаат во едниот под-интервал ќе ги смести во другиот, и обратно.

     Влез: Во првиот ред даден е бројот на војници. Во вториот ред дадени се ID-то на секој од војниците. Во третиот ред дадени се два броеви,
     ID на првиот војник и ID на последниот војник од првиот интервал. Во четвртиот ред дадени се два броеви, ID на првиот војник и ID на последниот војник од вториот интервал.

     Излез: Да се испечати новиот редослед на војниците (т.е. на нивните ID-a)

     Забелешка 1: Интервалите никогаш нема да се преклопуваат и ќе содржат барем еден војник. Целата низа ќе содржи најмалку два војника.
     Забелешка 2: Обратете посебно внимание кога интервалите се еден до друг и кога некој од интервалите почнува од првиот војник или завршува со последниот војник.
*/

public class DLLVojska {
    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] ids = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(ids[i]));
        }

        s = stdin.readLine();
        String interval[] = s.split(" ");
        int a = Integer.parseInt(interval[0]);
        int b = Integer.parseInt(interval[1]);

        s = stdin.readLine();
        interval = s.split(" ");
        int c = Integer.parseInt(interval[0]);
        int d = Integer.parseInt(interval[1]);


        DLL<Integer> result = vojska(lista, a, b, c, d);


        DLLNode<Integer> node = result.getFirst();
        System.out.print(node.getElement());
        node = node.getSucc();
        while(node != null){
            System.out.print(" " + node.getElement());
            node = node.getSucc();
        }

    }

    private static DLL<Integer> vojska(DLL<Integer> lista, int a, int b, int c, int d) {
        // Vasiot kod tuka
        int ai =0, bi = 0, ci = 0, di = 0;
        DLL<Integer> temp = new DLL<>();
        DLL<Integer> finalList = new DLL<>();
        int n = lista.length();
        DLLNode<Integer> tmpFirst = lista.getFirst();
        DLLNode<Integer> insert = null;
        for (int i = 0; i < n; i++) {
            if(tmpFirst.getElement() == a) {
                ai = i;
            }
            if(tmpFirst.getElement() == b) {
                bi = i;
            }
            if(tmpFirst.getElement() == c) {
                ci = i;
            }
            if(tmpFirst.getElement() == d) {
                di = i;
                break;
            }

            tmpFirst = tmpFirst.getSucc();
        }
        int count=0;
        tmpFirst = lista.getFirst();
        for (int i = 0; i < n || count < temp.length(); i++) {
            if (i >= ai && i <= bi) {
                temp.insertLast(tmpFirst.getElement());
            } else if (i >= ci && i <= di) {
                if(count < temp.length()){
                    finalList.insertLast(temp.getFirst().getElement());
                    temp.deleteFirst();
                }
                temp.insertLast(tmpFirst.getElement());
                count++;
            } else if (i < n){
                finalList.insertLast(tmpFirst.getElement());
            }
            if(count < temp.length() && i >= di) {
                finalList.insertLast(temp.getFirst().getElement());
                temp.deleteFirst();
            }
            if (insert == null) {
                if(ai != 0) {
                    if (i == ai) {
                        insert = finalList.getLast();
                    }
                }
            }

            if(tmpFirst != null){
                tmpFirst = tmpFirst.getSucc();
            }
        }
        System.out.println("tempbefore " + temp);
        System.out.println("listbefore " + finalList);
        int len = temp.length();
        if (ai == 0) {
            for (int i = 0; i < len; i++) {
                System.out.println("i " + i);
                finalList.insertFirst(temp.getLast().getElement());
                temp.deleteLast();
                System.out.println("temp1 " + temp);
                System.out.println("list1 " + finalList);
            }
        }else{
            for (int i = 0; i < len; i++) {
                finalList.insertAfter(temp.getLast().getElement(),insert);
                temp.deleteLast();
            }
        }
        return finalList;
    }
}
