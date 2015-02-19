package fr.xebia.workshop.java.functionalprogramming;

import java.util.Objects;

import static java.util.Objects.hash;

public class Some<A> implements Option<A> {

    private final A value;

    public Some(final A value) {
        this.value = value;
    }

    /*
     * Utilities.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Some other = (Some) o;
        return Objects.equals(value, other.getValue());
    }

    @Override
    public int hashCode() {
        return hash(value);
    }

    /*
     * Getters & setters.
     */
    public A getValue() {
        return value;
    }
}
