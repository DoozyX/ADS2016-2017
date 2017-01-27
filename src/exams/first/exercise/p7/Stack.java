package exams.first.exercise.p7;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    boolean isEmpty ();
    // Vrakja true ako i samo ako stekot e prazen.

    E peek ();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    void clear ();
    // Go prazni stekot.

    void push (E x);
    // Go dodava x na vrvot na stekot.

    E pop ();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}