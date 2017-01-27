package labs.lab10.p3;

import java.util.HashMap;
import java.util.Scanner;

/**
 Cities Problem 3
 You are given a map with one way roads between N cities in Macedonia.
 For each road you are given the length of the road, the starting city and the destination city.
 Find the minimal distance from one city to another and back, and print the roads you are going to take.

 The map with roads is given as a directed weighted graph.

 Input: In the first line you are given the number of cities N.
 In the second line you are given the number of roads M.
 In the following M lines you are given the roads as following:
 the number of the starting city,
 the name of the starting city,
 the number of the destination city,
 the name of the destination city,
 length of the road.
 In the last 2 lines you are given the names of the starting and the destination city.

 Output: In the first line of the output you are supposed to print the route which you are supposed to take starting from the starting city and ending at the destination city.
 In the second line you are supposed to print the route which you are supposed to take starting from the destination city and ending at the starting city.
 In the last line of the output you are supposed to print a single integer representing the total length of the routes.

 Sample input
 2
 2
 0 Skopje 1 Bitola 129
 1 Bitola 0 Skopje 135
 Skopje
 Bitola

 Sample output
 Skopje Bitola
 Bitola Skopje
 264.0
 */

public class Cities {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		Graph<String> graph = new Graph<>(n);
		HashMap<String, Integer> hashMap = new HashMap<>();

		int m = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < m; i++) {
			String[] line = scanner.nextLine().split("\\s+");

			int nCity1 = Integer.parseInt(line[0]);
			String city1 = line[1];
			graph.adjList[nCity1].setIndex(nCity1);
			graph.adjList[nCity1].setInfo(city1);
			hashMap.put(city1, nCity1);

			int nCity2 = Integer.parseInt(line[2]);
			String city2 = line[3];
			graph.adjList[nCity2].setIndex(nCity2);
			graph.adjList[nCity2].setInfo(city2);
			hashMap.put(city2, nCity2);

			float distance = Float.parseFloat(line[4]);
			graph.addEdge(nCity1, nCity2, distance);
		}

		String starting = scanner.nextLine();
		int startingIndex = hashMap.get(starting);

		String destination = scanner.nextLine();
		int destinationIndex = hashMap.get(destination);

		Path pathTo = graph.dijkstraPath(startingIndex);
		Path pathBack = graph.dijkstraPath(destinationIndex);

		System.out.println(pathTo.path[destinationIndex]);
		System.out.println(pathBack.path[startingIndex]);

		System.out.println(pathTo.distance[destinationIndex] + pathBack.distance[startingIndex]);

	}
}
