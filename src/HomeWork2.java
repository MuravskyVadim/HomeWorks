public class HomeWork2 {
    private static final double ACCURACY = 0.0001;

    public static void main(String[] args) {
        System.out.println(booleanExpression(false, false, false, false));
        System.out.println(booleanExpression(true, true, true, true));
        System.out.println(booleanExpression(false, false, true, true));
        System.out.println(booleanExpression(true, true, false, false));
        System.out.println(booleanExpression(true, false, false, false));
        System.out.println(booleanExpression(true, true, true, false));
        System.out.println(booleanExpression(false, true, true, false));
        System.out.println(booleanExpression(true, false, false, true));

        System.out.println(leapYearCount(1));
        System.out.println(leapYearCount(4));
        System.out.println(leapYearCount(100));
        System.out.println(leapYearCount(101));
        System.out.println(leapYearCount(400));
        System.out.println(leapYearCount(2016));

        System.out.println(doubleExpression(0.1, 0.2, 0.3));
        System.out.println(doubleExpression(0.0001, 0.0002, 0.0003));
        System.out.println(doubleExpression(0.0001, -0.0002, 0.0003));

        System.out.println(flipBit(13, 1));
        System.out.println(flipBit(13, 2));
        System.out.println(flipBit(13, 3));
        System.out.println(flipBit(13, 4));

    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (((a ^ b) && (c ^ d)) || ((a ^ c) && (b ^ d)));
    }

    public static int leapYearCount(int year) {
        return year / 4 - year / 100 + year / 400;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) <= ACCURACY;
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ 1 << --bitIndex;
    }
}
