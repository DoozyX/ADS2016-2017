package labs.lab1.p2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLL<E extends Comparable<E>> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = "";
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp != null) {
                if (tmp.succ == null) {
                    ret += tmp;
                }else {
                    ret += tmp + "->";
                }

                tmp = tmp.succ;
            }
        } else
            ret = "Empty list.";
        return ret;
    }

    public void insertFirst(E o) {
        first = new SLLNode<>(o, first);
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            node.succ = new SLLNode<>(o, node.succ);
        } else {
            System.out.println("Given node is null.");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<>(o, before);
            } else {
                System.out.println("The element does not exist in the list.");
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("The list is empty.");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first ==node){
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("The element does not exist in the list.");
                return null;
            }
        } else {
            System.out.println("The list is empty.");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("The element does not exist in the list.");
            }
        } else {
            System.out.println("The list is empty.");
        }
        return first;
    }

    public Iterator<E> iterator () {
        // Return an iterator that visits all elements of this list, in left-to-right order.
        return new LRIterator<>();
    }

    // //////////Inner class ////////////

    private class LRIterator<E> implements Iterator<E> {

        private SLLNode<E> place, curr;

        private LRIterator() {
            place = (SLLNode<E>) first;
            curr = null;
        }

        public boolean hasNext() {
            return (place != null);
        }

        public E next() {
            if (place == null)
                throw new NoSuchElementException();
            E nextElem = place.element;
            curr = place;
            place = place.succ;
            return nextElem;
        }

        public void remove() {
            //Not implemented
        }
    }

    public void mirror(){
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }

    }

    public void merge (SLL<E> in){
        if (first != null) {
            SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }

    private void fillRest(SLLNode<E> node, SLL<E> result, SLLNode<E> resultLast) {
        if(node != null) {
            while(node != null ) {
                if(!node.equalsValue(resultLast) ){
                    result.insertLast(node.element);
                }

                resultLast = new SLLNode<> (node.element, node.succ);
                node = node.succ;
            }

        }
    }


    public SLL<E> joinLists(SLL<E> list) {
        SLL<E> result = new SLL<>();

        SLLNode<E> node1 = this.getFirst();
        SLLNode<E> node2 = list.getFirst();
        SLLNode<E> resultLast = new SLLNode<>();

        while(node1 != null && node2 != null) {
            if(node1.element.compareTo(node2.element) < 0) {
                if(!node1.equalsValue(resultLast)) {
                    result.insertLast(node1.element);
                }
                resultLast = new SLLNode<>(node1.element, node1.succ);
                node1 = node1.succ;
            }
            else if (node1.element.compareTo(node2.element) > 0 ) {
                if(!node2.equalsValue(resultLast)) {
                    result.insertLast(node2.element);
                }
                resultLast = new SLLNode<>(node2.element, node2.succ);
                node2 = node2.succ;
            }else {
                if(!node1.equalsValue(resultLast)) {
                    result.insertLast(node1.element);
                }
                resultLast = new SLLNode<>(node1.element, node1.succ);

                node1 = node1.succ;
                node2 = node2.succ;
            }
        }

        this.fillRest(node1, result, resultLast);
        this.fillRest(node2, result, resultLast);

        return result;
    }

    public SLL<E> specialJoin(SLL<E> list1, SLL<E> list2) {
            SLL<E> result = new SLL<>();

            SLLNode<E> node1 = list1.getFirst();
            SLLNode<E> node2 = list2.getFirst();

            int count=0;
            while(node1 != null && node2 != null) {
                if(count < 2){
                    result.insertLast(node1.element);
                    node1 = node1.succ;
                }else if(count == 3){
                    result.insertLast(node2.element);
                    node2 = node2.succ;
                    count = -1;
                }else {
                    result.insertLast(node2.element);
                    node2 = node2.succ;
                }
                count++;

            }

            if(node1 != null) {
                while(node1 != null ) {
                    result.insertLast(node1.element);
                    node1 = node1.succ;
                }
            }
            if(node2 != null) {
                while(node2 != null ) {
                    result.insertLast(node2.element);
                    node2 = node2.succ;
                }
            }
            return result;
    }
}
