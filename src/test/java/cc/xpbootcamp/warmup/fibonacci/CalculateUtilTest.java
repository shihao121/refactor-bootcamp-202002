package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateUtilTest {
    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        assertEquals(1, CalculateUtil.calculate(1));
    }
}
