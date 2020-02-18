package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertFalse;

class OrderReceiptTest {
    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<Good> goods = new ArrayList<Good>() {{
            add(new Good("milk", 10.0, 2));
            add(new Good("biscuits", 5.0, 5));
            add(new Good("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, goods, LocalDate.of(2020, 2, 18)));

        String output = receipt.printReceipt();

        assertThat(output, containsString("===== 老王超市，值得信赖 ======"));
        assertThat(output, containsString("milk, 10.0 × 2, 20.0\n"));
        assertThat(output, containsString("biscuits, 5.0 × 5, 25.0\n"));
        assertThat(output, containsString("chocolate, 20.0 × 1, 20.0\n"));
        assertThat(output, containsString("-----------------------------------\n"));
        assertThat(output, containsString("税额: 6.5\n"));
        assertThat(output, containsString("总价: 71.5\n"));
    }

    @Test
    void should_display_date_and_week_info() {
        List<Good> goods = new ArrayList<Good>() {{
            add(new Good("milk", 10.0, 2));
            add(new Good("biscuits", 5.0, 5));
            add(new Good("chocolate", 20.0, 1));
        }};
        Order order = new Order("Mr X", "Chicago, 60601", goods,
                LocalDate.of(2020, 2, 18));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年02月18日"));
        assertThat(output, containsString("星期二\n"));
        assertFalse(output.contains("折扣"));
    }

    @Test
    void should_display_discount_price() {
        List<Good> goods = new ArrayList<Good>() {{
            add(new Good("milk", 10.0, 2));
            add(new Good("biscuits", 5.0, 5));
            add(new Good("chocolate", 20.0, 1));
        }};
        Order order = new Order("Mr X", "Chicago, 60601", goods,
                LocalDate.of(2020, 2, 19));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年02月19日"));
        assertThat(output, containsString("星期三\n"));
        assertThat(output, containsString("折扣: 1.43\n"));
    }
}