package labs.lab9.p3;

import java.util.Scanner;

/**
 Social network Problem 3
 It is given a social network (Facebook) where an ordinal number (integer), name and surname are stored for each user.
 The friends of the users are known also.
 Write an algorithm that for given ordinal numbers of two users finds the degree of separation between the users (i.e. the minimum number of users to get from one to another user) in the social network.

 The social network is represented as an unweighted graph with the adjacency list. The number of users is given in the first input line.
 The second line contains the number of friends of the first user (with ordinal number 0) and in the next lines his/her friends are listed (each represented with an ordinal number, name and surname).
 The information about all users is given in the same way. The last two input lines contain the ordinal numbers of the 2 users that a degree of separation should be found for.

 Sample input
 3
 2
 1 Ilinka Ivanoska
 2 Igor Kulev
 1
 0 Magdalena Kostoska
 1
 0 Magdalena Kostoska
 0
 1

 Sample output
 1
 */

public class CountFacebookFriends {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] nodes = new String[n];
		Graph<String> graph = new Graph<>(n,nodes);
		for (int i = 0; i < n; i++) {
			int nFriends = scanner.nextInt();
			for (int j = 0; j < nFriends; j++) {
				int num = scanner.nextInt();
				String name = scanner.next() + scanner.nextLine();
				graph.adjList[i].addNeighbor(new GraphNode<>(num,name));
			}
		}
		int from = scanner.nextInt();
		int to = scanner.nextInt();
		System.out.println(graph.findDistance(from,to));
	}
}
