package labs.lab2.p1;

public class DLLNode<E extends Comparable<E>> {
    protected E element;
    protected int count;
    protected DLLNode<E> pred, succ;

    DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
        this.count = 1;
    }

    public E getElement() {
        return element;
    }

    public int getCount() {
        return count;
    }

    public DLLNode<E> getPred() {
        return pred;
    }

    public DLLNode<E> getSucc() {
        return succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}





