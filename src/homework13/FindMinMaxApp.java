package homework13;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinMaxApp {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(22, 43, 67, 11, 13, 99);
        Comparator<Integer> order = Comparator.comparing(i -> i);
        BiConsumer<Integer, Integer> minMaxConsumer = (min, max) -> System.out.println(min + " " + max);
        findMinMax(integerStream, order, minMaxConsumer);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());

        if (list.size() != 0) {
            T min = list.stream().min(order).get();
            T max = list.stream().max(order).get();
            minMaxConsumer.accept(min, max);
        } else {
            minMaxConsumer.accept(null, null);
        }
    }
}
