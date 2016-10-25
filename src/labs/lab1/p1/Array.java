package labs.lab1.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*      Average Problem 1 (1 / 1)
        For a given array with N (1≤N≤50) integers, find the element which is the closest to the average. If there are two elements with the same distance to the average, return the smaller.
        For example for the array 1, 2, 3, 4, 5 the average is (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5 = 3, which means that the element which is the closest to the average is 3.

        For the array 1, 2, 3, 4, 5, 6 the average is 3.5 and both 3 and 4 are equally distant to the average. The correct answer is the smaller value which is 3.

        There can be duplicates in the array.

        The first number in the input is the number of elements in the array N, then the elements of the array follow in each line.
*/

public class Array<E> {
    public static int brojDoProsek(int[] niza ){
        //Code here...
        int n = niza.length;
        int sum = 0;
        for (int aNiza : niza) {
            sum += aNiza;
        }
        double average = (double)sum / n;

        double minDistance = Math.abs(niza[0] - average);
        int minNumber= niza[0];

        for (int i = 1; i < n; ++i) {
            double distance = Math.abs(niza[i] - average);
            if (distance < minDistance) {
                    minNumber = niza[i];
                    minDistance = distance;
            }else if (distance == minDistance) {
                if (niza[i] < minNumber) {
                    minNumber = niza[i];
                    minDistance = distance;
                }
            }
        }
        return minNumber;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        //Code here...
        int niza[] = new int[N];

        for (int i = 0; i < N; ++i) {
            niza[i] = Integer.parseInt(stdin.readLine());
        }

        System.out.println(brojDoProsek(niza));
    }



}