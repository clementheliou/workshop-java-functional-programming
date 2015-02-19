package fr.xebia.workshop.java.functionalprogramming;

public interface Option<A> {

    default A getOrElse(final A defaultValue) {
        if (this instanceof Some) return ((Some<A>) this).getValue();
        else return defaultValue;
    }

    default Option<A> orElse(final Option<A> alternative) {
        if(this instanceof Some) return this;
        else return alternative;
    }
}
