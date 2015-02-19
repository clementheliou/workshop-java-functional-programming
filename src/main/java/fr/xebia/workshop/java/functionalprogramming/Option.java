package fr.xebia.workshop.java.functionalprogramming;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Option<A> {

    @SuppressWarnings("unchecked")
    default Option<A> filter(final Predicate<A> p) {
        if (this instanceof Some) {
            final Some<A> some = (Some<A>) this;

            if (p.test(some.getValue())) return some;
            else return None.INSTANCE;

        } else {
            return None.INSTANCE;
        }
    }

    @SuppressWarnings("unchecked")
    default <B> Option<B> flatMap(final Function<A, Option<B>> f) {
        if (this instanceof Some) {
            final Some<A> some = (Some<A>) this;
            return f.apply(some.getValue());
        } else {
            return None.INSTANCE;
        }
    }

    default A getOrElse(final A defaultValue) {
        if (this instanceof Some) return ((Some<A>) this).getValue();
        else return defaultValue;
    }

    @SuppressWarnings("unchecked")
    default <B> Option<B> map(final Function<A, B> f) {
        if (this instanceof Some) {
            final Some<A> some = (Some<A>) this;
            return new Some<>(f.apply(some.getValue()));
        } else {
            return None.INSTANCE;
        }
    }

    default Option<A> orElse(final Option<A> alternative) {
        if (this instanceof Some) return this;
        else return alternative;
    }
}
