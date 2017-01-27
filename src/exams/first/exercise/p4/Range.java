package exams.first.exercise.p4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 Опсег Problem 4 (0 / 0)
 Дадена е равенката: x2+s(x)+200·x=N каде што x, N се природни броеви, а s(x) е функција која што го дава збирот на цифри на бројот x.
 Даден е и бројот N и два природни броеви A и B, каде што A≤B и A, B≤1,000,000,000. Потребно е да проверите дали постои природен број x во опсегот [A, B] така што е задоволена равенката,
 и ако постои тогаш треба да се врати како резултат. Ако таков природен број x во опсегот [A, B] што ја задоволува равенката не постои, тогаш се враќа -1.

 Sample input
 1456
 10 80

 Sample output
 -1
 */

public class Range {
    private static int sum(long n) {
        int sum = 0;
        while (n>0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    static long equation(long n) {
        return n * n + sum(n) + 200*n;
    }

    static long proveri(long N, long A, long B) {
        // Vasiot kod tuka
        long middle = (A + B) / 2;
        if (equation(middle) == N) {
            return middle;
        }
        if (A == B) {
            return -1;
        }
        if (equation(middle) > N) {
            return proveri(N, A, middle);
        } else {
            return proveri(N, middle + 1, B);
        }
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long res = proveri(N, A, B);
        System.out.println(res);

        br.close();

    }

}
