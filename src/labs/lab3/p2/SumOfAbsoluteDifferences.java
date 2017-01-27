package labs.lab3.p2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 Sum of absolute differences (partial exam exercise) Problem 2
 It is given an array of N natural numbers and number K. Let the numbers be labeled from a0 to aN−1.
 The sum of the absolute differences is defined as abs(a1−a0)+abs(a2−a1)+…+abs(aN−1−aN−2). Choose exactly K successive numbers in the array such that when they will be merged in one array,
 the sum of the absolute differences is maximum. Print this sum.

 Input: The two numbers N (1≤N≤100) and K (1≤K≤100, K≤N) are given in the first line. Second line contains N positive natural numbers and each number is less than 1,000.

 Output: Print the maximum sum of absolute differences.

 Note: Numbers must be taken in the given order. It is not allowed to change the order of the numbers in the new array.
 */

public class SumOfAbsoluteDifferences {
    static void matrixToString(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length ; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println();
    }
    static int solve(int numbers[], int N, int K) {
        // your code here
        int maxSum = 0;
        int[][] arr = new int[N][K];

        for (int i = 0; i < N; ++i) {
            System.out.println("i " + i);
            matrixToString(arr);
            for (int j = 1; j < K; ++j) {
                for (int k = 0; k < i; ++k){
                    arr[i][j] = Math.max(arr[i][j], arr[k][j-1] + Math.abs(numbers[i] - numbers[k]));
                }

                if(j == K-1) {
                    maxSum = Math.max(maxSum, arr[i][j]);
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}
/*
    {
        for (int i = 1; i < n; i++) {

            for (int j = 1; j < k; j++) {

                for (int h = 0; h < i; h++) {


                    if (dp[i][j] < dp[h][j - 1] + Math.abs(numbers[i] - numbers[h])) {


                        dp[i][j] = dp[h][j - 1] + Math.abs(numbers[i] - numbers[h]);

                    }


                    if (j == k - 1 && rez < dp[i][j]) rez = dp[i][j];

                }
            }
        }*/
