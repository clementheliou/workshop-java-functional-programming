package fr.xebia.workshop.java.functionalprogramming;

import org.junit.Test;

public class OptionTest {

    // Exercise 1

    @Test
    public void should_provide_an_empty_element() {
        final Option emptyElement = None.INSTANCE;
    }

    @Test
    public void should_provide_a_single_argument_constructor() {
        new Some<>(2);
    }

    // Exercise 2

    //    @Test
//    public void should_return_default_value_when_getOrElse_is_called_on_empty_option() {
//
//        // Arrange
//        @SuppressWarnings("unchecked")
//        final Option<Integer> emptyOption = None.INSTANCE;
//
//        // Act
//        final Integer result = emptyOption.getOrElse(0);
//
//        // Assert
//        assertThat(result).isEqualTo(0);
//    }

//    @Test
//    public void should_return_wrapped_value_when_getOrElse_is_called_on_filled_option() {
//
//        // Arrange
//        final Option<Integer> anOption = new Some<>(3);
//
//        // Act
//        final Integer result = anOption.getOrElse(0);
//
//        // Assert
//        assertThat(result).isEqualTo(3);
//    }
}
