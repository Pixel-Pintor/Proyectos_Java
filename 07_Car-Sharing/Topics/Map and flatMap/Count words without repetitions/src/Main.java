import java.util.*;
import java.util.stream.*;

public class Main {

    /**
     * Counts the number of unique words ignoring case sensitivity
     * for given lines with words.
     *
     * @param n     the n lines contain words
     * @param lines the list of lines, each line is a list of words
     * @return the number of unique words in lines ignoring case sensitivity
     */
    public static long count(int n, List<List<String>> lines) {

        return lines.stream()
                .flatMap(Collection::stream)
                .map(String::toLowerCase)
                .distinct()
                .count();
    }

    // Don't change the code below
    public static void main(String[] args) {
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

        List<Integer> generated1 = numbers.stream()
                .flatMap(n -> Stream.generate(() -> n).limit(n))
                .collect(Collectors.toList());

        System.out.println(generated1);

        List<Integer> generated2 = numbers.stream()
                .flatMapToInt(n -> IntStream.rangeClosed(1, n))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(generated2);

        List<Integer> generated3 = numbers.stream()
                .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(generated3);

        List<Integer> generated4 = numbers.stream()
                .flatMap(Stream::of)
                .collect(Collectors.toList());

        System.out.println(generated4);
    }
}