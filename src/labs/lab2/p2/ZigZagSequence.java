package labs.lab2.p2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {
    private static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka
        int longest = 1;
        int current = 1;
        int previous = 0;
        for (int anA : a) {
            if (anA > 0) {
                if (previous < 0) {
                    current++;
                } else {
                    if (current > longest) {
                        longest = current;
                    }
                    current = 1;
                }
            } else if (anA < 0) {
                if (previous > 0) {
                    current++;
                } else {
                    if (current > longest) {
                        longest = current;
                    }
                    current = 1;
                }
            } else {
                if (current > longest) {
                    longest = current;
                }
                current = 1;
            }
            previous = anA;
        }
        if (current > longest) {
            longest = current;
        }
        return longest;
    }

    public static void main(String[] args) throws Exception {
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}