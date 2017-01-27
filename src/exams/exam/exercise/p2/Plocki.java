package exams.exam.exercise.p2;

import java.util.Scanner;

class Plocki {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n+1];
		a[0] = 4;
		a[1] = 13;

		for (int i = 2; i < n ; i++) {
			a[i] = 3*a[i-1] + a[i-2];
		}

		System.out.println(a[n-1]);
	}
}
