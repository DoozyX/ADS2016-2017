package labs.lab6.p3;

import labs.lab6.p1.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Translator Problem 3
 You are supposed to make an automated translator, that translates words from English to Macedonian.

 Input: In the first line you are given a single integer N. In the following N lines you are given two words separated with a single white space.
 The first one is on Macedonian and the second is on English. Use this pairs of words to create, a dictionary. After this you are given a single English word in every line, until the word "КРАЈ" is read.

 Output: On the standard output you should print the Macedonian translation of the English words, using the dictionary you previously created. If you can't find a word in the dictionary print "/"

 Note. Use open buckets hash table. You are supposed to define the hash table and write the hash function by yourself.

 Sample input
 5
 machka cat
 kuche dog
 prase pig
 papagal parrot
 riba fish
 cat
 parrot
 fish
 KRAJ

 Sample output
 machka
 papagal
 riba

 */

public class Preveduvac {
    static boolean is_prime(int x) {
        for (int i = 3; true; i += 2) {
            int q = x / i;
            if (x == q * i)
                return false;
            if (q < i)
                return true;
        }
    }

    static int next_prime(int x) {
        if (x <= 2)
            return 2;
        if ((1 & x) == 0)
            ++x;
        for (; !is_prime(x); x += 2)
            ;
        return x;
    }
    public static void main (String[] args) throws IOException {
        OBHT<Zbor, String> tabela;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //---Vie odluchete za goleminata na hesh tabelata----
        tabela = new OBHT<>(next_prime((int) Math.floor(1.75 * N)));
        for (int i = 1; i <= N; i++) {
            String zbor = br.readLine();
            String[] pom = zbor.split(" ");
            tabela.insert(new Zbor(pom[1]), pom[0]);
        }
        String zbor;
        while (!(zbor = br.readLine()).equals("KRAJ")) {
            int pos = tabela.search(new Zbor(zbor));
            if (pos == -1) {
                System.out.println("/");
            } else {
                System.out.println(tabela.getBucket(pos).value);
            }
        }
    }
}
