package cc.xpbootcamp.warmup.cashier.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {
    public static String ofWeek(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("E", Locale.CHINESE));
    }
}
