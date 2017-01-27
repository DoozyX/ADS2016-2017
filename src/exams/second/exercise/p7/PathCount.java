package exams.second.exercise.p7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 Вкупен број на патишта Problem 7 (0 / 0)
 Да се испечати вкупниот број на патишта со должина N кои почнуваат од некое фиксно теме V во неориентиран нетежински граф.

 Влез: Во првиот ред е даден бројот на јазли, во вториот ред е даден бројот на ребра, а потоа во следните редови се дадени ребрата во графот. Во претпоследниот ред се дадени темето V и во последниот ред, должината N на патиштата.

 Излез: Испечатете го вкупниот број на патишта со должина N. Јазлите во патот можат да се повторуваат.

 Во дадениот пример, постојат два пата 0 1 2 и 0 1 0, кои почнуваат од јазолот 0 и имаат должина 2.

 Sample input
 6
 5
 0 1
 1 2
 2 3
 3 4
 4 5
 1
 4

 Sample output
 10
 */

class Graph<E> {

	int num_nodes; // broj na jazli
	E nodes[]; // informacija vo jazlite - moze i ne mora?
	int adjMat[][]; // matrica na sosednost

	@SuppressWarnings("unchecked")
	public Graph(int num_nodes) {
		this.num_nodes = num_nodes;
		nodes = (E[]) new Object[num_nodes];
		adjMat = new int[num_nodes][num_nodes];

		for (int i = 0; i < this.num_nodes; i++)
			for (int j = 0; j < this.num_nodes; j++)
				adjMat[i][j] = 0;
	}

	int adjacent(int x, int y) { // proveruva dali ima vrska od jazelot so
		// indeks x do jazelot so indeks y
		return (adjMat[x][y] != 0) ? 1 : 0;
	}

	void addEdge(int x, int y) { // dodava vrska megu jazlite so indeksi x i y
		adjMat[x][y] = 1;
		adjMat[y][x] = 1;
	}

	void deleteEdge(int x, int y) {
		// ja brise vrskata megu jazlite so indeksi x i y
		adjMat[x][y] = 0;
		adjMat[y][x] = 0;
	}

	E get_node_value(int x) { // ja vraka informacijata vo jazelot so indeks x
		return nodes[x];
	}

	void set_node_value(int x, E a) { // ja postavuva informacijata vo jazelot
		// so indeks na a
		nodes[x] = a;
	}

	@Override
	public String toString() {
		String ret = "  ";
		for (int i = 0; i < num_nodes; i++)
			ret += nodes[i] + " ";
		ret += "\n";
		for (int i = 0; i < num_nodes; i++) {
			ret += nodes[i] + " ";
			for (int j = 0; j < num_nodes; j++)
				ret += adjMat[i][j] + " ";
			ret += "\n";
		}
		return ret;
	}

	public void printMatrix() {
		for (int i = 0; i < num_nodes; i++) {
			for (int j = 0; j < num_nodes; j++)
				System.out.print(adjMat[i][j] + " ");
			System.out.println();
		}
	}

	public int pathCount(int nodeIndex,int pathLength){
		//vasiot kod tuka
		return -1;

	}

}

//check 98
public class PathCount {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Graph<Integer> g=new Graph<>(N);
		int M = Integer.parseInt(br.readLine());
		for (int i=0;i<M;i++){
			String line=br.readLine();
			String edgeLine[]=line.split(" ");
			g.addEdge(Integer.parseInt(edgeLine[0]), Integer.parseInt(edgeLine[1]));
		}
		int nodeIndex=Integer.parseInt(br.readLine());
		int pathLength=Integer.parseInt(br.readLine());
		System.out.println(g.pathCount(nodeIndex, pathLength));
		br.close();

	}

}
