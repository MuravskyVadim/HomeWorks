package homework11;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifferenceApp {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);

        System.out.println(symmetricDifference(set1, set2));
    }

    private static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> newSet = new HashSet<>(set1);
        Set<T> newSet2 = new HashSet<>(set2);

        newSet.removeAll(set2);
        newSet2.removeAll(set1);
        newSet.addAll(newSet2);
        return newSet;
    }
}
