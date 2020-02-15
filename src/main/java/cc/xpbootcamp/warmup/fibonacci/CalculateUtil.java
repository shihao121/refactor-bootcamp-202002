package cc.xpbootcamp.warmup.fibonacci;

public class CalculateUtil {
    public static int calculate(int position) {
        validatePosition(position);
        if (position == 1) {
            return 1;
        }
        return 0;
    }

    private static void validatePosition(int position) {
        if (position > 50 || position < 0) {
            throw new IllegalArgumentException("out of border");
        }
    }
}
