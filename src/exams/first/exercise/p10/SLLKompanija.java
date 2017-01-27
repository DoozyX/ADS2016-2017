package exams.first.exercise.p10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Компанија Problem 10
 Податоците за плати на вработените во една компанија привремено се чуваат во еднострано поврзана листа. Во секој јазол од листата се чува единствен ID на вработениот и неговата плата. Потребно е да се отстранат сите вработени со помали плати од даден износ, а остатокот да се прикажат во опаѓачки редослед во однос на ID-то. Во првиот ред од влезот е даден бројот на вработени, потоа наизменично се дадени ID и плата за секој од вработените и во последниот ред е износот во однос на кој ќе се отстрануваат вработените. На излез се печати листа (ID, плата) во опаѓачки редослед според ID на секој од вработените.

 Доколку нема вработени со плата поголема од дадената да се испечати: nema

 Sample input
 3
 1111
 19000
 2222
 22000
 1155
 60000
 30000

 Sample output
 1155 60000
 */

public class SLLKompanija {
    public static void main(String[] args) throws IOException {

        SLL lista1 = new SLL();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        for (int i = 0; i < N; i++) {
            s=stdin.readLine();
            String s1=stdin.readLine();
            lista1.insertLast(Integer.parseInt(s),Integer.parseInt(s1));
        }
        s = stdin.readLine();

        lista1=lista1.brisi_pomali_od(Integer.parseInt(s));
        if(lista1!=null)
        {
            lista1=lista1.sortiraj_opagacki();
            lista1.pecati(lista1);
        }

    }
}
