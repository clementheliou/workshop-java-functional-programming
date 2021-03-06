package fr.xebia.workshop.java.functionalprogramming;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface List<A> {

    @SuppressWarnings("unchecked")
    static List<Integer> addOne(final List<Integer> values) {
        return values.map((x) -> x + 1);    }

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
    default List<A> filter(final Predicate<A> p) {
        if (this instanceof Cons) {
            final Cons<A> cons = (Cons<A>) this;

            if (p.test(cons.getHead())) return new Cons(cons.getHead(), cons.getTail().filter(p));
            else return cons.getTail().filter(p);

        } else {
            return Nil.INSTANCE;
        }
    }

    @SuppressWarnings("unchecked")
    default <B> List<B> flatMap(final Function<A, List<B>> f) {
        return map(f).foldRight((List<B>) Nil.INSTANCE, (current, total) -> {
            return current.foldRight(total, Cons::new);
        });
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

    static <A> List<A> join(final List<A> left, final List<A> right) {
        if (left instanceof Nil) return right;
        if (right instanceof Nil) return left;

        final Cons<A> cons = (Cons<A>) left;

        if (cons.getTail() instanceof Nil) return new Cons<>(cons.getHead(), right);
        else return new Cons<>(cons.getHead(), join(cons.getTail(), right));
    }

    default Integer length() {
        return foldLeft(0, (total, y) -> total + 1);
    }

    @SuppressWarnings("unchecked")
    default <B> List<B> map(final Function<A, B> f) {
        if (this instanceof Cons) {
            final Cons<A> cons = (Cons<A>) this;
            return new Cons<>(f.apply(cons.getHead()), cons.getTail().map(f));
        } else {
            return Nil.INSTANCE;
        }
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

    @SuppressWarnings("unchecked")
    static List<String> toString(final List<?> values) {
        return values.map((x) -> x.toString());    }
}
