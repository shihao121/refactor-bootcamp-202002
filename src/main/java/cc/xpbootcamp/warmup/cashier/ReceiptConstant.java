package cc.xpbootcamp.warmup.cashier;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReceiptConstant {
    public static final String RECEIPT_HEADER = "===== 老王超市，值得信赖 ======\n\n";
    public static final String SALES_TAX_TOPIC = "税额";
    public static final String TOTAL_AMOUNT_TOPIC = "总价";
    public static final String SEPARATOR_CHARACTER = ", ";
    public static final String MULTIPLY_CHARACTER = " × ";
    public static final String COLON_CHARACTER = ": ";
    public static final char NEW_LINE_ESCAPE_SEQUENCES = '\n';
    public static final String SEPARATING_LINE = "-----------------------------------\n";
    public static final String DISCOUNT_TOPIC = "折扣";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy年M月dd日");
}
