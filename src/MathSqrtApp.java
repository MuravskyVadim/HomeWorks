public class MathSqrtApp {
    public static void main(String[] args) {
        System.out.println(sqrt(0));
        System.out.println(sqrt(4.0));
        System.out.println(sqrt(-4));
        System.out.println(sqrt(Double.POSITIVE_INFINITY));
        System.out.println(sqrt(Double.NEGATIVE_INFINITY));
    }

    public static double sqrt(double x) throws IllegalArgumentException {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
    }
}
