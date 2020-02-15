package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculateUtilTest {
    private static Stream<Arguments> provideFibonacciNumberForSpecifyPosition() {
        return Stream.of(
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(50, 12586269025L)
        );
    }

    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        assertEquals(1L, CalculateUtil.calculate(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 51, 52})
    void should_throw_exception_when_position_is_out_of_border(int position) {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculateUtil.calculate(position);
        });
    }

    @Test
    void should_return_0_when_calculate_given_position_is_0() {
        assertEquals(0L, CalculateUtil.calculate(0));
    }

    @ParameterizedTest
    @MethodSource("provideFibonacciNumberForSpecifyPosition")
    void should_return_fibonacci_number_when_calculate_given_position_is_in_specify_interval(int position, long fibonacciNumber) {
        assertEquals(fibonacciNumber, CalculateUtil.calculate(position));
    }
}
