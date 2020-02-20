package cc.xpbootcamp.warmup.cashier.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {
    @Test
    void should_get_chinese_week_info_from_date() {
        assertEquals("星期二", DateUtil.ofWeek(LocalDate.of(2020, 2, 18)));
    }
}