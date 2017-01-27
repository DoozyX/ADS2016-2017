package exams.second.exercise.test;

import java.util.Scanner;

public class TheLoneInteger {
	public static int findLoneInt(int[] array) {
		int lenght = array.length, count;
		for (int i = 0; i < lenght; ++i) {
			count = 0;
			for (int j = 0; j < lenght ; ++j) {
				if (array[i] == array[j]) {
					++count;
				}
			}
			if (count == 1) {
				return array[i];
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println(findLoneInt(array));
	}
}