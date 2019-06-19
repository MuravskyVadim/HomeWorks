package homework12;

import java.util.stream.IntStream;

public class PseudoRandomStreamApp {

    public static void main(String[] args) {
        int seed = 13;

        for (int n : pseudoRandomStream(seed).toArray()) {
            System.out.print(n + " ");
        }
    }

    public static IntStream pseudoRandomStream(int seed) {
        if (seed < 0) {
            return null;
        }
        return IntStream.iterate(seed, n -> n * n / 10 % 1000).limit(15);
    }
}
