package cc.xpbootcamp.warmup.fibonacci;

public class CalculateUtil {
    public static int calculate(int position) {
        if (position > 50 || position <= 0) {
            throw new IllegalArgumentException("out of border");
        }
        return 1;
    }
}
