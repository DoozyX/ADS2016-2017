package exams.first.exercise.p6;

import java.util.Arrays;
import java.util.Scanner;

/**
 Најдолга опаѓачка секвенца - Java Problem 6
 Најди ја најдолгата опаѓачка секвенца во една низа. Броевите во секвенцата не мора да се наоѓаат на последователни индекси во низата.

 Sample input
 8
 1 2 3 4 5 6 7 8

 Sample output
 1
 */

public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {
        // Vasiot kod tuka
        int n = a.length;
        int[] max = new int[n];
        Arrays.fill(max,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[i] < a[j]) {
                    max[i] = Math.max(max[i],1+max[j]);
                }
            }
        }
        return Arrays.stream(max).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}