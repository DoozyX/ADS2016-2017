package labs.lab4.p1;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Creating new empty stack
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Returns true only if the stack is empty.

        return (depth == 0);
    }


    public E peek () {
        // Returns the element on the top od the stack.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Clears the stack.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        // Adds x on the top of the stack.
        elems[depth++] = x;
    }


    public E pop () {
        // Removes and returns the element on the top.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}
