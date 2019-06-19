package homework12;

import java.util.function.DoubleUnaryOperator;

public class IntegrateApp {

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));
        System.out.println(integrate(x -> Math.pow(x, 2), -5, 5));
        System.out.println(integrate(x -> Math.sqrt(x), 0, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double accuracy = 1e-6;
        double sum = 0;

        while (a <= b) {
            sum += f.applyAsDouble(a) * accuracy;
            a += accuracy;
        }
        return sum;
    }
}
