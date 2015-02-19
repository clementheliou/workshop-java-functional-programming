package fr.xebia.workshop.java.functionalprogramming;

import java.util.function.BiFunction;

public interface List<A> {

    static Integer compute(final List<Integer> values, final Integer neutral, final BiFunction<Integer, Integer, Integer> f) {
        if (values instanceof Cons) {
            final Cons<Integer> cons = (Cons<Integer>) values;
            return f.apply(cons.getHead(), compute(cons.getTail(), neutral, f));
        } else {
            return neutral;
        }
    }

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

    static Integer product(final List<Integer> values) {
        return compute(values, 1, (x, y) -> x * y);
    }


    static Integer sum(final List<Integer> values) {
        return compute(values, 0, (x, y) -> x + y);
    }

    @SuppressWarnings("unchecked")
    default List<A> tail() {
        return drop(1);
    }
}
