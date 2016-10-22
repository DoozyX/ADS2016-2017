package labs.lab1.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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