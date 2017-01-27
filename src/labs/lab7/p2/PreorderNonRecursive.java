package labs.lab7.p2;

/**
 Non recursive preorder traversal Problem 2
 Write a function peorderNonRecursive for non recursive preorder traversal of binary tree.

 Sample input
 8
 0 A ROOT
 1 B LEFT 0
 2 C LEFT 1
 3 D RIGHT 1
 4 E RIGHT 0
 5 F RIGHT 4
 6 G LEFT 5
 7 H RIGHT 5

 Sample output
 A B C D E F G H
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

public class PreorderNonRecursive {

    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<String> nodes[] = new BNode[N];
        BTree<String> tree = new BTree<>();

        for (i=0;i<N;i++)
            nodes[i] = new BNode<>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
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

        tree.PreorderNonRecursive();

    }
}
