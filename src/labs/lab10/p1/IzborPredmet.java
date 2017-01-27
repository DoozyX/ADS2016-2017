package labs.lab10.p1;

import java.util.HashMap;
import java.util.Scanner;

/**
 University Subjects Problem 1
 On one university there are mandatory and elective subjects. For each subject you are given, a list of subjects that need to be passed in order to be eligible for that subject is given.
 Find the next available subject for you, if you know what is the last subject that you have passed.

 Input: In the first line you are given a single integer N representing the number of elements.
 In the following N lines you are given the IDs of the subjects.
 In the following line you are given a single integer M representing the number of dependencies between the subjects.
 In the following M lines you are given a list of IDs separated with a single white space.
 Starting from the second ID to the last ID you have the subjects that you need to pass in order to be able to take the subjected defined with the first ID in this line.
 In the last line you are given the last subject that you have passed.

 Output: The output should contain a single ID representing the next available subject.

 Sample input
 5
 Z1
 Z2
 I1
 I2
 I3
 3
 I1 Z1 Z2
 I2 I1
 I3 Z2 I2
 I2

 Sample output
 I3
 */
public class IzborPredmet {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] nodes = new String[n];
		HashMap<String, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String name = scanner.nextLine();
			nodes[i] = name;
			hashMap.put(name, i);
		}
		Graph<String> graph = new Graph<>(n, nodes);
		int m = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < m; i++) {
			String line = scanner.nextLine();
			String[] dependence = line.split("\\s+");
			int len = dependence.length;
			for (int j = 1; j < len; j++) {
				graph.addEdge(hashMap.get(dependence[j]),hashMap.get(dependence[0]));
			}
		}
		String passed = scanner.nextLine();
		System.out.println(graph.findNextTopological(passed));
	}
}
