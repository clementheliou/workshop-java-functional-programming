package fr.xebia.workshop.java.functionalprogramming;

import java.util.Objects;

import static java.util.Objects.hash;

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

    /*
     * Utilities.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Cons other = (Cons) o;

        return Objects.equals(head, other.head)
                && Objects.equals(tail, other.tail);
    }

    @Override
    public int hashCode() {
        return hash(head, tail);
    }

    /*
     * Getters & setters.
     */
    public A getHead() {
        return head;
    }

    public List<A> getTail() {
        return tail;
    }
}
