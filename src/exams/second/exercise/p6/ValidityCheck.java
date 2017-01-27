package exams.second.exercise.p6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 Проверка на валидност Problem 6 (0 / 0)
 Да се напише функција ValidityCheck што ќе провери дали кај дадено дрво важи дека за секој јазел неговите деца имаат info-поле со помала или еднаква вредност од вредноста на info-полето на тој јазел и во зависност од тоа да се испечати true или false.

 Sample input
 8
 0 50 ROOT
 1 48 LEFT 0
 2 45 LEFT 1
 3 44 RIGHT 1
 4 32 RIGHT 0
 5 30 RIGHT 4
 6 25 LEFT 5
 7 25 RIGHT 5

 Sample output
 true
 */

class BNode<E> {

	public E info;
	public BNode<E> left;
	public BNode<E> right;

	static int LEFT = 1;
	static int RIGHT = 2;

	public BNode(E info) {
		this.info = info;
		left = null;
		right = null;
	}

	public BNode() {
		this.info = null;
		left = null;
		right = null;
	}

	public BNode(E info, BNode<E> left, BNode<E> right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}

}

class BTree<E> {

	public BNode<E> root;

	public BTree() {
		root = null;
	}

	public BTree(E info) {
		root = new BNode<E>(info);
	}

	public void makeRoot(E elem) {
		root = new BNode(elem);
	}

	public void makeRootNode(BNode<E> node) {
		root = node;
	}

	public BNode<E> addChild(BNode<E> node, int where, E elem) {

		BNode<E> tmp = new BNode<E>(elem);

		if (where == BNode.LEFT) {
			if (node.left != null)  // veke postoi element
				return null;
			node.left = tmp;
		} else {
			if (node.right != null) // veke postoi element
				return null;
			node.right = tmp;
		}

		return tmp;
	}

	public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

		if (where == BNode.LEFT) {
			if (node.left != null)  // veke postoi element
				return null;
			node.left = tmp;
		} else {
			if (node.right != null) // veke postoi element
				return null;
			node.right = tmp;
		}

		return tmp;
	}

}

public class ValidityCheck {

	public static void main(String[] args) throws Exception {
		int i, j, k;
		int index;
		String action;

		String line;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		BNode<Integer> nodes[] = new BNode[N];
		BTree<Integer> tree = new BTree<Integer>();

		for (i=0;i<N;i++)
			nodes[i] = new BNode<Integer>();

		for (i = 0; i < N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			index = Integer.parseInt(st.nextToken());
			nodes[index].info = Integer.parseInt(st.nextToken());
			action = st.nextToken();
			if (action.equals("LEFT")) {
				tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
			} else if (action.equals("RIGHT")) {
				tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
			} else {
				// this node is the root
				tree.makeRootNode(nodes[index]);
			}
		}

		br.close();

		// vasiot kod ovde


	}
}

