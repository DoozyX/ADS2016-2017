package labs.lab8.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 Successors Problem 2
 Using a threaded binary tree and inorder traversal check if every next element is equal to the previous element + 1. You are allowed to use additional functions as long as they are not recursive.

 Write true or false to the standard output.

 Sample input
 8
 0 48 ROOT
 1 46 LEFT 0
 2 45 LEFT 1
 3 47 RIGHT 1
 4 50 RIGHT 0
 5 51 RIGHT 4
 6 50 LEFT 5
 7 52 RIGHT 5

 Sample output
 false
 */
/*
public class ConsecutiveNumbers {
    public static void main(String[] args) throws IOException{
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

        for (int i = 0; i < N; i++) {
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
    }

}
*/

import java.util.Scanner;
class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;
    char ltag;
    char rtag;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
        ltag = '-';
        rtag = '-';
    }

}
class BTree<E> {

    public BNode<E> head;

    public BTree() {
        head = new BNode<E>(null);
        head.left = head;
        head.ltag = '-';
        head.right = head;
        head.rtag = '+';
    }

    public BNode<E> makeRoot(E elem) {
        BNode<E> tmp = new BNode<E>(elem);
        head.left = tmp;
        head.ltag = '+';

        tmp.left = head;
        tmp.ltag = '-';
        tmp.right = head;
        tmp.rtag = '-';

        return tmp;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {

            if (node.ltag == '+')
                return null;

            tmp.left = node.left;
            tmp.ltag = '-';
            tmp.right = node;
            tmp.rtag = '-';
            node.left = tmp;
            node.ltag = '+';
        } else {

            if (node.rtag == '+')
                return null;

            tmp.right = node.right;
            tmp.rtag = '-';
            tmp.left = node;
            tmp.ltag = '-';
            node.right = tmp;
            node.rtag = '+';
        }

        return tmp;
    }

    public BNode<E> insertRight(BNode<E> parent, E info) {

        BNode<E> child = new BNode<E>(info);

        child.ltag = '-';
        child.left = parent;
        child.rtag = parent.rtag;
        child.right = parent.right;

        parent.right = child;
        parent.rtag = '+';

        if (child.rtag == '+') {
            BNode<E> temp = child.right;
            while (temp.ltag == '+')
                temp = temp.left;
            temp.left = child;
        }

        return child;
    }

    public BNode<E> predecessorInorder(BNode<E> node) {

        if (node.ltag == '-') {
            return node.left;
        }

        BNode<E> p = node.left;
        while (p.rtag == '+') {
            p = p.right;
        }

        return p;
    }

    public BNode<E> successorInorder(BNode<E> node) {

        if (node.rtag == '-')
            return node.right;

        BNode<E> p = node.right;
        while (p.ltag == '+') {
            p = p.left;
        }

        return p;
    }

    public boolean inorderNonRecursive() {

        if (head.ltag == '-') {
            return false;
        }

        BNode<E> p = head.left;

        while (p.ltag == '+') {
            p = p.left;
        }

        while (successorInorder(p) != head) {
            if(!successorInorder(p).info.equals((Integer)p.info+1)) {
                return false;
            }
            p = successorInorder(p);
        }
        return true;

    }
    public BNode<E> findNode(E vrednost)
    {
        BNode<E> p = head.left;

        while (p.ltag == '+')
            p = p.left;

        while (p != head) {
            if(p.info.equals(vrednost))
                return p;
            p = successorInorder(p);
        }
        return null;
    }

}

public class ConsecutiveNumbers
{
    public static void main(String args[]) throws IOException {
        int index = 0;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BTree<Integer> tree=new BTree<>();
        BNode<Integer> curr;

        int nodes[]=new int[N];


        for(int j=0;j<N;j++)
        {
            line = br.readLine();
            String pom[]=line.split(" ");
            int i=Integer.parseInt(pom[0]);
            nodes[i]=Integer.parseInt(pom[1]);
            String tip=pom[2];
            if(!tip.equals("ROOT")) {
                index=Integer.parseInt(pom[3]);
                if (index!=0) {
                    curr=tree.findNode(nodes[index]);
                } else curr=tree.head.left;
                if (tip.equals("LEFT")) {
                    tree.addChild(curr,BNode.LEFT,nodes[i]);
                } else if(tip.equals("RIGHT")) {
                    tree.addChild(curr,BNode.RIGHT,nodes[i]);
                }
            } else {
                tree.makeRoot(nodes[i]);
            }

        }
        br.close();
        System.out.println(tree.inorderNonRecursive());
    }
}
