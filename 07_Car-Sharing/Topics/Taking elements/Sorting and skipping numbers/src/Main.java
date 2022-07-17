import java.util.*;
import java.util.stream.Collectors;

class ProcessNumbers {

    public static List<Integer> processNumbers(Collection<Integer> numbers) {
        return numbers
                .stream()
                .sorted(Comparator.naturalOrder())
                .dropWhile(n -> n < 10)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> fibonacci = List.of(0, 1, 1, 2, 3, 5, 8, 13);

        List<Integer> result = fibonacci.stream()
                .dropWhile(n -> n > 5)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}