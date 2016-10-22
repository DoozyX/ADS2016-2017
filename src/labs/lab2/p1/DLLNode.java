package labs.lab2.p1;

class DLLNode<E extends Comparable<E>> {
    protected E element;
    protected int count;
    protected DLLNode<E> pred, succ;

    DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
        this.count = 1;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}





