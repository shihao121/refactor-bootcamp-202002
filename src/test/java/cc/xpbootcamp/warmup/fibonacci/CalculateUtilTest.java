package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculateUtilTest {
    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        assertEquals(1, CalculateUtil.calculate(1));
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
        assertEquals(0, CalculateUtil.calculate(0));
    }
}
