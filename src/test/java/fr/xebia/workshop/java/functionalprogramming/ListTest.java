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

    @Test
    public void should_return_an_empty_list_when_drop_is_called_on_empty_list() {

        // Arrange
        final List emptyList = Nil.INSTANCE;

        // Act
        final List result = emptyList.drop(2);

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_return_an_empty_list_when_drop_size_is_greater_that_list_length() {

        // Arrange
        final List<Integer> aList = new Cons<>(2, new Cons<>(4));

        // Act
        final List<Integer> result = aList.drop(15);

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_return_all_elements_except_the_first_n_ones_when_drop_is_called_on_non_empty_list() {

        // Arrange
        final List<Integer> aList = new Cons<>(2, new Cons<>(4, new Cons<>(6, new Cons<>(1))));

        // Act
        final List<Integer> result = aList.drop(2);

        // Assert
        assertThat(result).isEqualTo(new Cons<>(6, new Cons<>(1)));
    }

    // Exercise 4

    @Test
    public void should_return_an_empty_list_when_init_is_called_on_empty_list() {

        // Arrange
        final List emptyList = Nil.INSTANCE;

        // Act
        final List result = emptyList.init();

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_return_an_empty_list_when_init_is_called_on_single_element_list() {

        // Arrange
        final List<Integer> singleElementList = new Cons<>(2);

        // Act
        final List<Integer> result = singleElementList.init();

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_return_all_elements_except_the_last_one_when_init_is_called_on_multiple_elements_list() {

        // Arrange
        final List<Integer> aList = new Cons<>(2, new Cons<>(3, new Cons<>(6)));

        // Act
        final List<Integer> result = aList.init();

        // Assert
        assertThat(result).isEqualTo(new Cons<>(2, new Cons<>(3)));
    }

    // Exercise 5

    @Test
    public void should_return_zero_when_sum_is_called_on_empty_list() {

        // Arrange
        @SuppressWarnings("unchecked")
        final List<Integer> emptyList = Nil.INSTANCE;

        // Act
        final Integer result = List.sum(emptyList);

        // Assert
        assertThat(result).isZero();
    }

    @Test
    public void should_return_the_sum_of_values_when_sum_is_called_on_non_empty_list() {

        // Arrange
        final List<Integer> aList = new Cons<>(3, new Cons<>(5, new Cons<>(9)));

        // Act
        final Integer result = List.sum(aList);

        // Assert
        assertThat(result).isEqualTo(17);
    }

    // Exercise 6

    @Test
    public void should_return_one_when_product_is_called_on_empty_list() {

        // Arrange
        @SuppressWarnings("unchecked")
        final List<Integer> emptyList = Nil.INSTANCE;

        // Act
        final Integer result = List.product(emptyList);

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_the_product_of_values_when_product_is_called_on_non_empty_list() {

        // Arrange
        final List<Integer> aList = new Cons<>(2, new Cons<>(5, new Cons<>(12)));

        // Act
        final Integer result = List.product(aList);

        // Assert
        assertThat(result).isEqualTo(120);
    }

    // Exercise 8

    @Test
    public void should_return_zero_when_length_is_called_on_empty_list() {

        // Arrange
        final List emptyList = Nil.INSTANCE;

        // Act
        final Integer result = emptyList.length();

        // Assert
        assertThat(result).isZero();
    }

    @Test
    public void should_return_list_size_when_length_is_called_on_non_empty_list() {

        // Arrange
        final Cons<Integer> aList = new Cons<>(4, new Cons<>(6));

        // Act
        final Integer result = aList.length();

        // Assert
        assertThat(result).isEqualTo(2);
    }

    // Exercise 10

    @Test
    public void should_return_an_empty_list_when_addOne_is_called_on_empty_list() {

        // Arrange
        @SuppressWarnings("unchecked")
        final List<Integer> emptyList = Nil.INSTANCE;

        // Act
        final List<Integer> result = List.addOne(emptyList);

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_increment_each_value_by_one_when_addOne_is_called_on_non_empty_integers_list() {

        // Arrange
        final List<Integer> aList = new Cons<>(2, new Cons<>(6));

        // Act
        final List<Integer> result = List.addOne(aList);

        // Assert
        assertThat(result).isEqualTo(new Cons<>(3, new Cons<>(7)));
    }

    // Exercise 11

    @Test
    public void should_return_an_empty_list_when_toString_is_called_on_empty_list() {

        // Arrange
        final List emptyList = Nil.INSTANCE;

        // Act
        final List<String> result = List.toString(emptyList);

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_give_each_element_string_representation_when_toString_is_called_on_non_empty_List() {

        // Arrange
        final List<Integer> aList = new Cons<>(3, new Cons<>(6));

        // Act
        final List<String> result = List.toString(aList);

        // Assert
        assertThat(result).isEqualTo(new Cons<>("3", new Cons<>("6")));
    }

    // Exercise 13

    @Test
    public void should_return_an_empty_list_when_filter_is_called_on_empty_list() {

        // Arrange
        @SuppressWarnings("unchecked")
        final List<Integer> emptyList = Nil.INSTANCE;

        // Act
        final List<Integer> result = emptyList.filter((p) -> p % 2 == 0);

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_return_an_empty_list_when_filter_is_called_on_empty_list_with_a_predicate_that_does_not_match() {

        // Arrange
        final List<Integer> aList = new Cons<>(3, new Cons<>(5));

        // Act
        final List<Integer> result = aList.filter((p) -> p % 2 == 0);

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_return_matching_elements_when_filter_is_called_on_empty_list_with_a_matching_predicate() {

        // Arrange
        final List<Integer> aList = new Cons<>(2, new Cons<>(3, new Cons<>(5)));

        // Act
        final List<Integer> result = aList.filter((p) -> p % 2 == 0);

        // Assert
        assertThat(result).isEqualTo(new Cons<>(2));
    }

    // Exercise 14

    @Test
    public void should_return_the_left_list_when_joining_an_non_empty_list_with_an_empty_one() {

        // Arrange
        final List<Integer> nonEmptyList = new Cons<>(2);

        // Act
        @SuppressWarnings("unchecked")
        final List<Integer> result = List.join(nonEmptyList, Nil.INSTANCE);

        // Assert
        assertThat(result).isEqualTo(nonEmptyList);
    }

    @Test
    public void should_return_the_right_list_when_joining_an_empty_list_with_an_non_empty_one() {

        // Arrange
        final List<Integer> nonEmptyList = new Cons<>(2);

        // Act
        @SuppressWarnings("unchecked")
        final List<Integer> result = List.join(Nil.INSTANCE, nonEmptyList);

        // Assert
        assertThat(result).isEqualTo(nonEmptyList);
    }

    @Test
    public void should_return_list_concatenation_when_joining_non_empty_lists() {

        // Arrange
        final List<Integer> left = new Cons<>(2, new Cons<>(4));
        final List<Integer> right = new Cons<>(5, new Cons<>(8));

        // Act
        final List<Integer> result = List.join(left, right);

        // Assert
        assertThat(result).isEqualTo(new Cons<>(2, new Cons<>(4, new Cons<>(5, new Cons<>(8)))));
    }

    // Exercise 15

    @Test
    public void should_return_an_empty_list_when_flatMap_is_called_on_empty_list() {

        // Arrange
        @SuppressWarnings("unchecked")
        final List<String> emptyList = Nil.INSTANCE;

        // Act
        final List<String> result = emptyList.flatMap((name) -> new Cons<>(name.toUpperCase(), new Cons<>(name.toLowerCase())));

        // Assert
        assertThat(result).isEqualTo(Nil.INSTANCE);
    }

    @Test
    public void should_return_a_list_of_all_lowercased_uppercased_names_when_flatMap_is_called_on_non_empty_list() {

        // Arrange
        final List<String> aList = new Cons<>("Harry", new Cons<>("Potter"));

        // Act
        final List<String> result = aList.flatMap((name) -> new Cons<>(name.toUpperCase(), new Cons<>(name.toLowerCase())));

        // Assert
        assertThat(result).isEqualTo(new Cons<>("HARRY", new Cons<>("harry", new Cons<>("POTTER", new Cons<>("potter")))));
    }
}
