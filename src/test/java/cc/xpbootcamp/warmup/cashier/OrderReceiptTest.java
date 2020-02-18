package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<Good>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<Good> goods = new ArrayList<Good>() {{
            add(new Good("milk", 10.0, 2));
            add(new Good("biscuits", 5.0, 5));
            add(new Good("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, goods));

        String output = receipt.printReceipt();

        assertThat(output, containsString("===== 老王超市，值得信赖 ======"));
        assertThat(output, containsString("milk, 10.0 × 2, 20.0\n"));
        assertThat(output, containsString("biscuits, 5.0 × 5, 25.0\n"));
        assertThat(output, containsString("chocolate, 20.0 × 1, 20.0\n"));
        assertThat(output, containsString("-----------------------------------\n"));
        assertThat(output, containsString("税额: 6.5"));
        assertThat(output, containsString("总价: 71.5"));
    }

}