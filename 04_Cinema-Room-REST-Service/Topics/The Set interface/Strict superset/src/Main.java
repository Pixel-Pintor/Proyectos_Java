import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static <T> boolean isStrictSuperset(Set<T> set1, Set<T> set2) {
        // write your code here
        boolean equalSet = Objects.equals(set1, set2);
        boolean containsSet = set2.containsAll(set1);
        return !equalSet && containsSet;
    }

    /* Please do not change the code below */
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);

        // Set<String> set1 = readStringSet(scanner);
        // Set<String> set2 = readStringSet(scanner);

        // System.out.println(isStrictSuperset(set1, set2));

        Set<Integer> set = new HashSet<>(Set.of(1, 2, 3, 4));
        set.retainAll(Set.of(2, 3, 4, 5));
        set.removeAll(Set.of(1, 2));
        System.out.println(set);
    }

    private static Set<String> readStringSet(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toSet());
    }
}