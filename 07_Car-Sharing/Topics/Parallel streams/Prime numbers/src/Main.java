import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

class ParallelFilteringStream {

    public static LongStream createPrimesFilteringStream(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .parallel()
                .filter(NumberUtils::isPrime);
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 5, 4, 8, 9, 2);
        numbers.stream().sorted().forEach(System.out::println);
        numbers.parallelStream().sorted().forEachOrdered(System.out::println);
        numbers.parallelStream().sorted().sequential().forEach(System.out::println);
    }

    public static class NumberUtils {

        public static boolean isPrime(long n) {
            return n > 1 && LongStream
                    .rangeClosed(2, n - 1)
                    .noneMatch(divisor -> n % divisor == 0);
        }
    }
}