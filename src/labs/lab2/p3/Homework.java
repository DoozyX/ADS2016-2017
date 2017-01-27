package labs.lab2.p3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.*;

public class Homework {

    static int minBrojKazneni(int a[]) {
        // Your code here
        Arrays.sort(a);
        int N = a.length;
        int[] sums = new int[N];
        sums[0] = a[0];
        for (int i = 1; i< N; ++i) {
            sums[i] = sums[i-1] + a[i];
        }
        return IntStream.of(sums).sum();
    }

    public static void main(String[] args) throws Exception {
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];

        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = minBrojKazneni(a);

        System.out.println(rez);

        br.close();
    }
}
