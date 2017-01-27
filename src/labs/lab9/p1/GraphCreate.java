package labs.lab9.p1;

import java.util.Scanner;

/**
 Graph creation Problem 1
 Your task is to create an unoriented unweighted graph by using an adjacency matrix, where each vertex information is а character.
 You create the graph according to the received commands. You will be given an array of commands that can be one of the following:

 CREATE [number] - you should create new graph with the given number of vertices. The values of the vertices are the letters of the English alphabet, starting from the first letter.
 For example if you have 3 vertices, the letters will be: A, B и C.
 ADDEDGE [number1] [number2] - you should create an edge between the vertices with ordinal number number1 and ordinal number number2.
 DELETEEDGE [number1] [number2] - you should remove the edge between the vertices with ordinal number number1 and ordinal number number2. .
 ADЈACENT [number1] [number2] - you should print 1 if the vertices with ordinal number number1 and ordinal number number2 are adjacent, otherwise print 0.
 PRINTMATRIX - you should print the adjacency matrix. PRINTNODE [number] - you should print the vertex information (letter) for the given vertex ordinal number.

 The number of commands is given in the first input line.

 Sample input
 5
 CREATE 4
 ADDEDGE 0 3
 PRINTMATRIX
 PRINTNODE 2
 ADJACENT 0 2
 DELETEEDGE 3 0

 Sample output
 0 0 0 1
 0 0 0 0
 0 0 0 0
 1 0 0 0
 C
 0
 */

public class GraphCreate {
    static int toInt(String num) {
        return Integer.parseInt(num);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String line = input.nextLine();
        int num = Integer.parseInt(line.split("\\s+")[1]);
        String[] nodes = new String[num];
        for (int i = 0; i < num; i++) {
            nodes[i] = (char) ('A' + i) + "";
        }
        Graph<String> graph = new Graph<>(num, nodes);
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            String[] commands = line.split("\\s+");
            String command = commands[0];
            switch (command) {
                case "ADDEDGE":
                    graph.addEdge(toInt(commands[1]), toInt(commands[2]));
                    break;
                case "DELETEEDGE":
                    graph.deleteEdge(toInt(commands[1]),toInt(commands[2]));
                    break;
                case "ADJACENT":
                    System.out.println(graph.adjacent(toInt(commands[1]),toInt(commands[2])));
	                break;
                case "PRINTMATRIX":
                    graph.printAdjMat();
                    break;
                case "PRINTNODE":
                    System.out.println(graph.get_node_value(toInt(commands[1])));
                    break;
            }
        }
        input.close();
    }
}
