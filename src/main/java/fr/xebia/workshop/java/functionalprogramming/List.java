package fr.xebia.workshop.java.functionalprogramming;

import java.util.function.BiFunction;

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

    default <B> B foldLeft(final B z, final BiFunction<B, A, B> f) {
        if (this instanceof Cons) {
            final Cons<A> cons = (Cons<A>) this;

            if (cons.getTail() instanceof Nil) return f.apply(z, cons.getHead());
            else return cons.getTail().foldLeft(f.apply(z, cons.getHead()), f);

        } else {
            return z;
        }
    }

    default <B> B foldRight(final B z, final BiFunction<A, B, B> f) {
        if (this instanceof Cons) {
            final Cons<A> cons = (Cons<A>) this;
            return f.apply(cons.getHead(), cons.getTail().foldRight(z, f));
        } else {
            return z;
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

    default Integer length() {
        return foldLeft(0, (total, y) -> total + 1);
    }

    static Integer product(final List<Integer> values) {
        return values.foldLeft(1, (x, y) -> x * y);
    }


    static Integer sum(final List<Integer> values) {
        return values.foldLeft(0, (x, y) -> x + y);
    }

    @SuppressWarnings("unchecked")
    default List<A> tail() {
        return drop(1);
    }
}
