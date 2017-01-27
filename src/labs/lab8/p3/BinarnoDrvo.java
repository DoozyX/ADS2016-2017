package labs.lab8.p3;


import java.util.Scanner;

class BNode<E extends Comparable<E>> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}


class BinarySearchTree<E extends Comparable<E>> {


    private BNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(E x) {
        root = insert(x, root);
    }

    static int number=0;


    public void remove(E x) {
        root = remove(x, root);
    }

    public E findMin() {
        return elementAt(findMin(root));
    }


    public E findMax() {
        return elementAt(findMax(root));
    }


    public BNode<E> find(E x) {
        return find(x, root);
    }

    public void makeEmpty() {
        root = null;
    }


    public boolean isEmpty() {
        return root == null;
    }


    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }


    private E elementAt(BNode<E> t) {
        if (t == null)
            return null;
        return t.info;
    }

    private BNode<E> insert(E x, BNode<E> t) {
        if (t == null) {
            t = new BNode<E>(x, null, null);
        } else if (x.compareTo(t.info) < 0) {
            t.left = insert(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            t.right = insert(x, t.right);
        } else;  // Duplicate; do nothing
        return t;
    }

    private BNode<E> remove(Comparable x, BNode<E> t) {
        if (t == null)
            return t;   // Item not found; do nothing

        if (x.compareTo(t.info) < 0) {
            t.left = remove(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) { // Two children
            t.info = findMin(t.right).info;
            t.right = remove(t.info, t.right);
        } else {
            if (t.left != null)
                return t.left;
            else
                return t.right;
        }
        return t;
    }


    private BNode<E> findMin(BNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }


    private BNode<E> findMax(BNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t;
        }
        return findMax(t.right);
    }

    private BNode<E> find(E x, BNode<E> t) {
        if (t == null)
            return null;

        if (x.compareTo(t.info) < 0) {
            return find(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            return find(x, t.right);
        } else {
            return t;    // Match
        }
    }

    private void printTree(BNode<E> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.info);
            printTree(t.right);
        }
    }
    public int getHeight(BNode<E> t)
    {
        int levo=0;
        int desno=0;

        if(t.left==null && t.right==null)
            return 1;

        if(t.left!=null)
            levo=getHeight(t.left)+1;

        if(t.right!=null)
            desno=getHeight(t.right)+1;

        if(desno>levo)
            return desno;
        return levo;

    }



    public int naDLABOCINA(int n)
    {
        inorderCUSTOMr(root,n);
        int ind= number;

        number=0;

        return ind;

    }



    public void inorderCUSTOMr(BNode<E> t,int n) {
        if (t != null) {
            inorderCUSTOMr(t.left,n);
            check(t,n);
            inorderCUSTOMr(t.right,n);
        }
    }

    public void check(BNode<E> t,int n)
    {
        int dlabocina=findCUSTOMr(t.info, root);
        if(dlabocina==n)
            number++;
    }


    public int findCUSTOMr(E x, BNode<E> t) {
        if (t == null)
            return 0 ;

        if (x.compareTo(t.info) < 0) {
            return findCUSTOMr(x, t.left)+1;
        } else if (x.compareTo(t.info) > 0) {
            return findCUSTOMr(x, t.right)+1;
        } else {
            return 0;
        }
    }

}

public class BinarnoDrvo {
    public static void main(String[] args) throws Exception {
        int N;
        Scanner br = new Scanner(System.in);

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        N = Integer.parseInt(br.nextLine());
        int num;
        for(int i=0;i<N;i++) {
            num=Integer.parseInt(br.nextLine());
            tree.insert(num);
        }

        int M=Integer.parseInt(br.nextLine());
        BNode<Integer> node = tree.find(M);

        int height=tree.getHeight(node);
        System.out.println(height);

        System.out.println(tree.naDLABOCINA(height));
        br.close();
    }

}
