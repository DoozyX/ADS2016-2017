package labs.lab9.p2;

import java.util.Scanner;

/**
 Maze traversal Problem 2
 It is given a perfect maze (in the same form as presented on the aud. exercises - input of characters).
 Your task is to create a graph (unoriented and unweighted) by using the adjacency list from the given input and to print the path from the initial vertex (vertex denoted by S) to the final vertex (vertex denoted by E).

 Print the path as follows: print the coordinates of the unfolded vertices (i.e. print the positions from the input).

 Sample input
 6,6
 ######
 #S# E#
 # # ##
 #   ##
 ######
 ######

 Sample output
 1,1
 2,1
 3,1
 3,2
 3,3
 2,3
 1,3
 1,4

 */
public class Lavirint {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Maze m = new Maze();

		String[] dim = scanner.nextLine().split(",");
		int rows = Integer.parseInt(dim[0]);
		int columns = Integer.parseInt(dim[1]);
		String[] in = new String[rows];

		for (int i = 0; i < rows; i++) {
			in[i] = scanner.nextLine();
		}

		m.generateGraph(rows, columns, in);
		m.findPath();
	}
}
