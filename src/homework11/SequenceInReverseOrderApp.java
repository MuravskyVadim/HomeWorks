package homework11;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SequenceInReverseOrderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = "";

        if (scanner.hasNextLine()) {
            string = scanner.nextLine();
        }

        String[] strings = string.split(" ");
        sequenceInReverseOrder(strings);
    }

    private static void sequenceInReverseOrder(String[] strings) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < strings.length; i++) {
            if (i % 2 != 0) {
                deque.add(Integer.parseInt(strings[i]));
            }
        }

        while (!deque.isEmpty()) {
            System.out.print((deque.size() == 1) ? deque.pollLast() : deque.pollLast() + " ");
        }
    }
}
