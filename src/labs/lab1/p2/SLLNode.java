package labs.lab1.p2;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    public SLLNode() {
        this.element = null;
        this.succ = null;
    }

    @Override
    public String toString() {
        if(element != null){
            return element.toString();
        }
        return "";

    }

    public boolean equalsValue(Object o) {
        if (this == o) return true;
        if (!(o instanceof SLLNode)) return false;

        SLLNode<?> sllNode = (SLLNode<?>) o;

        return element != null ? element.equals(sllNode.element) : sllNode.element == null;
    }

    @Override
    public int hashCode() {
        int result = element != null ? element.hashCode() : 0;
        result = 31 * result + (succ != null ? succ.hashCode() : 0);
        return result;
    }
}
