package fr.xebia.workshop.java.functionalprogramming;

public interface List<A> {

    @SuppressWarnings("unchecked")
    default List<A> tail() {
        if (this instanceof Cons) return ((Cons<A>) this).getTail();
        else return Nil.INSTANCE;
    }
}
