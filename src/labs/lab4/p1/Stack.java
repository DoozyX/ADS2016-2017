package labs.lab4.p1;

interface Stack<E> {

    // The elements of the Stack are any kind of objects

    // Access methods:

    public boolean isEmpty ();
    // Returns true only if the stack is empty.

    public E peek ();
    // Returns the element on the top od the stack.

    // Transformation methods:

    public void clear ();
    // Clears the stack.

    public void push (E x);
    // Adds x on the top of the stack.

    public E pop ();
    // Removes and returns the element on the top.
}