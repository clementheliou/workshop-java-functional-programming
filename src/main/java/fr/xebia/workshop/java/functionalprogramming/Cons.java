package fr.xebia.workshop.java.functionalprogramming;

public class Cons<A> implements List<A> {

    private final A head;
    private final List<A> tail;

    public Cons(final A head, final List<A> tail) {
        this.head = head;
        this.tail = tail;
    }

    @SuppressWarnings(value = "unchecked")
    public Cons(final A head) {
        this(head, Nil.INSTANCE);
    }
}
