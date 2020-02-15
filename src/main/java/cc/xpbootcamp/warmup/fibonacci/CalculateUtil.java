package cc.xpbootcamp.warmup.fibonacci;

public class CalculateUtil {
    public static long calculate(int position) {
        validatePosition(position);
        if (position <= 1) {
            return position;
        }
        long previousFibonacci = 1;
        long beforePreviousFibonacci = 0;
        long fibonacciNumber = beforePreviousFibonacci + previousFibonacci;
        for (int i = 2; i < position; i++) {
            beforePreviousFibonacci = previousFibonacci;
            previousFibonacci = fibonacciNumber;
            fibonacciNumber = beforePreviousFibonacci + previousFibonacci;
        }
        return fibonacciNumber;
    }

    private static void validatePosition(int position) {
        if (position > 50 || position < 0) {
            throw new IllegalArgumentException("out of border");
        }
    }
}
