package fr.xebia.workshop.java.functionalprogramming;

public interface List<A> {

    @SuppressWarnings("unchecked")
    default List<A> drop(final int n) {
        if (this instanceof Cons) {
            final Cons<A> cons = (Cons<A>) this;

            if (n > 0) return cons.getTail().drop(n - 1);
            else return new Cons(cons.getHead(), cons.getTail());

        } else {
            return Nil.INSTANCE;
        }
    }

    @SuppressWarnings("unchecked")
    default List<A> init() {
        if (this instanceof Cons) {
            final Cons<A> cons = (Cons<A>) this;

            if (cons.getTail() instanceof Nil) return Nil.INSTANCE;
            else return new Cons<>(cons.getHead(), cons.getTail().init());

        } else {
            return Nil.INSTANCE;
        }
    }

    static Integer sum(final List<Integer> values) {
        if (values instanceof Cons) {
            final Cons<Integer> cons = (Cons<Integer>) values;
            return cons.getHead() + sum(cons.getTail());
        } else {
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    default List<A> tail() {
        return drop(1);
    }
}
