package labs.lab7.p3;

/**
 Sum of elements in a binary tree Problem 3
 You are given a binary tree and a node value in the tree.
 Print the sum of the elements of the node's left subtree that are lower than the given node value and the sum of the elements of the node's right subtree that are greater than the given node value.

 Sample input
 10
 0 10 ROOT
 1 19 LEFT 0
 2 8 LEFT 1
 3 7 LEFT 2
 4 60 RIGHT 2
 5 5 RIGHT 1
 6 4 RIGHT 0
 7 13 RIGHT 6
 8 2 LEFT 7
 9 1 RIGHT 7
 10

 Sample output
 20 13
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;





public class BinaryTreeSum {

    public static BNode<Integer> findNode(BNode<Integer> node, Integer x) {
        if(node != null){
            if(node.info.equals(x)){
                return node;
            } else {
                BNode<Integer> foundNode = findNode(node.left, x);
                if(foundNode == null) {
                    foundNode = findNode(node.right, x);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }

    public static int leftSum(BNode<Integer> node, int baranaVrednost) {

        if (node == null) {
            return 0;
        } else {
            if (node.info < baranaVrednost) {
                return node.info + leftSum(node.left, baranaVrednost) + leftSum(node.right, baranaVrednost);
            } else {
                return leftSum(node.left, baranaVrednost) + leftSum(node.right, baranaVrednost);
            }
        }
    }

    public static int rightSum(BNode<Integer> node, int baranaVrednost) {

        if (node == null) {
            return 0;
        } else {
            if (node.info > baranaVrednost) {
                return node.info + rightSum(node.left, baranaVrednost) + rightSum(node.right, baranaVrednost);
            } else {
                return rightSum(node.left, baranaVrednost) + rightSum(node.right, baranaVrednost);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<>();

        for (i=0;i<N;i++)
            nodes[i] = new BNode<>();

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
                tree.makeRootNode(nodes[index]);
            }
        }

        int baranaVrednost=Integer.parseInt(br.readLine());

        br.close();
        // vasiot kod ovde
        BNode<Integer> node = findNode(tree.root, baranaVrednost);
        System.out.println(leftSum(node.left, baranaVrednost) + " " + rightSum(node.right, baranaVrednost));
    }
}
