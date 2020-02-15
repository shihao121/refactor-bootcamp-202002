package cc.xpbootcamp.warmup.fibonacci;

public class CalculateUtil {
    public static long calculate(int position) {
        validatePosition(position);
        if (position == 1) {
            return 1L;
        }
        if (position == 0){
            return 0L;
        }
        return calculate(position - 1) + calculate(position - 2);
    }

    private static void validatePosition(int position) {
        if (position > 50 || position < 0) {
            throw new IllegalArgumentException("out of border");
        }
    }
}
