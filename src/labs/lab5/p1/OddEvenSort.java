package labs.lab5.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 Odd even sorting Problem 1 (0 / 0)
 You are given an array of N integers. The odd numbers should be put in the beginning of the array in ascending order,
 and the even numbers should be put at the end of the array in descending order.

 In the first line of the input you will find a single integer N, representing the number of integers in the array.
 In the second line of the input you will the elements of the array with a single whitespace between them.

 Sample input
 8
 6 10 13 5 8 17 2 5

 Sample output
 5 5 13 17 10 8 6 2
 */
public class OddEvenSort {
    static void oddEvenSort(int a[], int n) {
        // Vasiot kod tuka
        int[] even = new int[n];
        int[] odd = new int[n];
        int iE = 0, iO = 0;
        for (int i = 0 ; i < n; i++) {
            if (a[i] % 2 == 0) {
                even[iE++] = a[i];
            } else {
                odd[iO++] = a[i];
            }
        }
        int[] evenS = Arrays.copyOf(even, iE);
        int[] oddS = Arrays.copyOf(odd, iO);
        Arrays.sort(evenS);
        Arrays.sort(oddS);
        for (int i = 0; i < iO; i++) {
            a[i] = oddS[i];
        }
        for (int i = n-1, j = 0; i >= iO; i--) {
            a[i] = evenS[j++];
        }
    }

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i] + " ");
        System.out.print(a[i]);
    }
}