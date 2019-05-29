public class HW2 {
    public static void main(String[] args) {

    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (((a ^ b) & (c ^ d)) | ((a ^ c) & (b ^ d)));
    }

    public static int leapYearCount(int year) {
        return (year+(year/100)-(year/100)*4)/4;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.round(a*10000) + Math.round(b*10000) == Math.round(c*10000);
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ 1 << --bitIndex;
    }
}
