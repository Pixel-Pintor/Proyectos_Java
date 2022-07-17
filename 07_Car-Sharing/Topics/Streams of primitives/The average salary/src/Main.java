import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CalculateAverageSalary {

    private static double calcAverageSalary(Collection<Integer> salaries) {
        return salaries.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        IntStream.empty().summaryStatistics().toString().lines().forEach(System.out::println);
    }
}