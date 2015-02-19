package fr.xebia.workshop.java.functionalprogramming;

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

    default A getOrElse(final A defaultValue) {
        if (this instanceof Some) return ((Some<A>) this).getValue();
        else return defaultValue;
    }

    default Option<A> orElse(final Option<A> alternative) {
        if (this instanceof Some) return this;
        else return alternative;
    }
}
