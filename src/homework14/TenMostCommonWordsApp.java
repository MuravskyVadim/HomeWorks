package homework14;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class TenMostCommonWordsApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tenMostCommonWords(scanner.nextLine());
    }

    public static void tenMostCommonWords(String inputString) {
        Arrays.stream(
                inputString.toLowerCase().replaceAll("[^0-9a-zа-я]", " ").split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue((a, b) -> (int) (b - a)))
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
    }
}
