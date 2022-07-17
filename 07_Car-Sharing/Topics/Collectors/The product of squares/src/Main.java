import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CollectorProduct {

    public static void main(String[] args) {

        IntStream.iterate(10, (n) -> n + 1).limit(3).forEach(System.out::println);
    }
}