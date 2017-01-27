package exams.second.exercise.p2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 Inorder следбеник Problem 2
 Дадено ви е бинарно пребарувачко дрво. Напишете рекурзивна функција inorderSuccessor која што за дадена вредност во дрвото ќе го најде нејзиниот следбеник.

 Sample input
 10
 8
 2
 11
 6
 0
 9
 19
 3
 14
 16

 Sample output
 0
 2
 3
 6
 8
 9
 11
 14
 16
 19
 */

public class InorderSuccessor {

	public static void main(String[] args) throws Exception {
		int i,j,k;

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			tree.insert(num);
		}

		br.close();

		int prev = tree.findMin();
		System.out.println(prev);

		for (i=1;i<N;i++) {
			int tmp = tree.getSuccessor(prev);
			System.out.println(tmp);
			prev = tmp;
		}
	}

}