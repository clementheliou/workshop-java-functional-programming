package fr.xebia.workshop.java.functionalprogramming;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void should_return_default_value_when_getOrElse_is_called_on_empty_option() {

        // Arrange
        @SuppressWarnings("unchecked")
        final Option<Integer> emptyOption = None.INSTANCE;

        // Act
        final Integer result = emptyOption.getOrElse(0);

        // Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_wrapped_value_when_getOrElse_is_called_on_filled_option() {

        // Arrange
        final Option<Integer> anOption = new Some<>(3);

        // Act
        final Integer result = anOption.getOrElse(0);

        // Assert
        assertThat(result).isEqualTo(3);
    }

    // Exercise 3

        @Test
    public void should_return_alternative_option_when_orElse_is_called_on_empty_option() {

        // Arrange
        @SuppressWarnings("unchecked")
        final Option<Integer> emptyOption = None.INSTANCE;

        // Act
        final Option<Integer> result = emptyOption.orElse(new Some<>(6));

        // Assert
        assertThat(result).isEqualTo(new Some<>(6));
    }

    @Test
    public void should_return_current_option_when_orElse_is_called_on_non_empty_option() {

        // Arrange
        final Option<Integer> anOption = new Some<>(6);

        // Act
        final Option<Integer> result = anOption.orElse(new Some<>(7));

        // Assert
        assertThat(result).isSameAs(anOption);
    }

    // Exercise 4

    //    @Test
//    public void should_return_empty_option_when_filter_is_called_on_empty_option() {
//
//        // Arrange
//        @SuppressWarnings("unchecked")
//        final Option<Integer> emptyOption = None.INSTANCE;
//
//        // Act
//        final Option<Integer> result = emptyOption.filter((i) -> i % 2 == 0);
//
//        // Assert
//        assertThat(result).isEqualTo(None.INSTANCE);
//    }

//    @Test
//    public void should_return_empty_option_when_filter_is_called_on_filled_option_not_matching_it() {
//
//        // Arrange
//        final Option<Integer> anOption = new Some<>(7);
//
//        // Act
//        final Option<Integer> result = anOption.filter((i) -> i % 2 == 0);
//
//        // Assert
//        assertThat(result).isEqualTo(None.INSTANCE);
//    }

//    @Test
//    public void should_return_option_when_filter_is_called_on_filled_option_matching_it() {
//
//        // Arrange
//        final Option<Integer> anOption = new Some<>(6);
//
//        // Act
//        final Option<Integer> result = anOption.filter((i) -> i % 2 == 0);
//
//        // Assert
//        assertThat(result).isSameAs(anOption);
//    }
}
