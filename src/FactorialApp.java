import java.math.BigInteger;

public class FactorialApp {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(6));
        System.out.println(factorial(7));
    }

    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i)) ;
        }
        return result;
    }
}
