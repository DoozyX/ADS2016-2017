package labs.lab10.p2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 Hierarchy Problem 2
 One organisation has a single president and multiple regular members.
 If you know the collaboration degree (1 being perfect, 10 being worst) between the members choose the best hierarchy for the organisation.
 By best it means that the sum of all collaboration degrees between the members should be minimum.

 Input:

 In the first line of the input you are given a single integer N, representing the number of members the organisation has.
 In the second line of the input you are given a single integer M, representing the number of collaborations between members from the organisation.
 In the following M lines you are given the collaborations like following:
 ID of a member,
 name of that member,
 ID of a member,
 name of that member,
 degree of collaboration between the two members given previously.
 In the last line you are given the name of the president.

 Output:

 After choosing the best hierarchy print the sum of all collaboration degrees for that hierarchy.

 Sample input
 2
 1
 0 MagdalenaKostoska 1 IgorKulev 1
 MagdalenaKostoska

 Sample output
 1
 */
public class Hierarchy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Graph<String> graph = new Graph<>(n);
		int m = scanner.nextInt();
		scanner.nextLine();
		HashMap<String, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < m; i++) {
			String line = scanner.nextLine();
			String[] relations = line.split("\\s+");
			int degree = Integer.parseInt(relations[4]);

			int id1 = Integer.parseInt(relations[0]);
			String name1 = relations[1];
			hashMap.put(name1, id1);
			graph.adjList[id1].setInfo(name1);
			graph.adjList[id1].setIndex(id1);

			int id2 = Integer.parseInt(relations[2]);
			String name2 = relations[3];
			hashMap.put(name2, id2);
			graph.adjList[id2].setInfo(name2);
			graph.adjList[id2].setIndex(id2);

			graph.addEdge(id1, id2, degree);
		}

		String president = scanner.nextLine();
		int idPresident = hashMap.get(president);

		List<Edge> arrayList = graph.prim(idPresident);

		int sum = 0;
		for (Edge edge : arrayList) {
			sum += edge.getWeight();
		}

		System.out.println(sum);
	}
}
