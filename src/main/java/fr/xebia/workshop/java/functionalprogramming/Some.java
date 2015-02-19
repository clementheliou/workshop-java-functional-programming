package fr.xebia.workshop.java.functionalprogramming;

public class Some<A> implements Option<A> {

    private final A value;

    public Some(final A value) {
        this.value = value;
    }

    /*
     * Getters & setters.
     */
    public A getValue() {
        return value;
    }
}
