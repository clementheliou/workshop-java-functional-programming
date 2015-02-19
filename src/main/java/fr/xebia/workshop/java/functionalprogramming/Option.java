package fr.xebia.workshop.java.functionalprogramming;

public interface Option<A> {

    default A getOrElse(final A defaultValue) {
        if (this instanceof Some) return ((Some<A>) this).getValue();
        else return defaultValue;
    }
}
