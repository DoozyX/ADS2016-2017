package labs.lab5.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Shaker (cocktail) sort Problem 2
 * You are given array of N integers. This array should be sorted using the so called shaker(cocktail) sorting. This sorting algorithm is a variation of bubble sort.
 * Every iteration of the algorithm is consisted of two parts.
 * In the first part you are supposed to put the smallest element at the beginning of the array and in the second part you are supposed to put the biggest element at the end.
 * You continue this process until the array is fully sorted.
 * <p>
 * In the first line of the input you will find a single integer N, representing the number of integers in the array.
 * In the second line of the input you will find the elements of the array with a single whitespace between them.
 * <p>
 * The output should contain the state of the array after every iteration.
 * <p>
 * Sample input
 * 8
 * 6 10 13 5 8 17 2 5
 * <p>
 * Sample output
 * 2 6 10 13 5 8 17 5
 * 2 6 10 5 8 13 5 17
 * 2 5 6 10 5 8 13 17
 * 2 5 6 5 8 10 13 17
 * 2 5 5 6 8 10 13 17
 * 2 5 5 6 8 10 13 17
 * 2 5 5 6 8 10 13 17
 * 2 5 5 6 8 10 13 17
 */

public class ShakerSort {
    static void shakerSort(int a[], int n) {
        boolean done = true;
        int i = 0;
        while (done) {
            done = false;
            for (int j = n - 1; j > 0; --j) {
                if (a[j] < a[j-1]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                    done = true;
                }
            }
            for (int k = 0; k < n; ++k) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    done = true;
                }
            }
            for (int k = 0; k < n; ++k) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
            ++i;
        }
    }

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(pom[i]);
        shakerSort(a, n);
    }
}
