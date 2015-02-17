package fr.xebia.workshop.java.functionalprogramming;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {

    // Exercise 1

    @Test
    public void should_provide_an_empty_element() {
        final List emptyElement = Nil.INSTANCE;
    }

    @Test
    public void should_provide_a_single_argument_constructor() {
        new Cons<>(2);
    }

    @Test
    public void should_provide_a_bi_argument_constructor() {

        @SuppressWarnings("unchecked")
        final List<Integer> aList = new Cons<>(2, Nil.INSTANCE);
    }

    // Exercise 2

    @Test
    public void should_return_an_empty_list_when_tail_is_called_on_empty_list() {

        // Arrange
        final List emptyList = Nil.INSTANCE;

        // Act
        final List result = emptyList.tail();

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_return_an_empty_list_when_tail_is_called_on_single_element_list() {

        // Arrange
        final List<Integer> singleElementList = new Cons<>(2);

        // Act
        final List<Integer> result = singleElementList.tail();

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_return_all_elements_except_the_first_one_when_tail_is_called_on_multi_elements_list() {

        // Arrange
        final List<Integer> aList = new Cons<>(2, new Cons<>(3, new Cons<>(4)));

        // Act
        final List<Integer> result = aList.tail();

        // Assert
        assertThat(result).isEqualTo(new Cons<>(3, new Cons<>(4)));
    }

    // Exercise 3

//    @Test
//    public void should_return_an_empty_list_when_drop_is_called_on_empty_list() {
//
//        // Arrange
//        final List emptyList = Nil.INSTANCE;
//
//        // Act
//        final List result = emptyList.drop(2);
//
//        // Assert
//        assertThat(result).isEqualTo(Nil.INSTANCE);
//    }

//    @Test
//    public void should_return_an_empty_list_when_drop_size_is_greater_that_list_length() {
//
//        // Arrange
//        final List<Integer> aList = new Cons<>(2, new Cons<>(4));
//
//        // Act
//        final List<Integer> result = aList.drop(15);
//
//        // Assert
//        assertThat(result).isEqualTo(Nil.INSTANCE);
//    }

//    @Test
//    public void should_return_all_elements_except_the_first_n_ones_when_drop_is_called_on_non_empty_list() {
//
//        // Arrange
//        final List<Integer> aList = new Cons<>(2, new Cons<>(4, new Cons<>(6, new Cons<>(1))));
//
//        // Act
//        final List<Integer> result = aList.drop(2);
//
//        // Assert
//        assertThat(result).isEqualTo(new Cons<>(6, new Cons<>(1)));
//    }
}
