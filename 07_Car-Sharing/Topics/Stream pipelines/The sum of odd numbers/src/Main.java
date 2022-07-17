import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static long sumOfOddNumbersInRange(long start, long end) {
        List<Long> numbers = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            numbers.add(i);
        }
        return numbers.stream()
                .filter(n -> n % 2 == 1)
                .reduce(Long::sum).orElse(0L);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().trim().split(" ");

        long start = Integer.parseInt(line[0]);
        long end = Integer.parseInt(line[1]);

        System.out.println(sumOfOddNumbersInRange(start, end));
    }
}