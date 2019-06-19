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

        for (int i = strings.length - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                deque.add(Integer.parseInt(strings[i]));
                System.out.print(i == 1 ? deque.pollFirst() : deque.pollFirst() + " ");
            }
        }
    }
}
