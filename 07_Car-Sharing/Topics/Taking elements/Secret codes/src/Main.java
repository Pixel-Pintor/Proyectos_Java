import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class Main {

    private static List<String> extractCodes(List<String> codes) {
        return codes.stream()
                .dropWhile(Predicate.not("#0000"::equals))
                .skip(1)
                .takeWhile(Predicate.not("#FFFF"::equals))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<River> rivers = List.of(
                new River("Nile", 6650),
                new River("Amazon", 6400),
                new River("Yangtze", 6300),
                new River("Mississippi", 6275),
                new River("Yenisei", 5539),
                new River("Huang He", 5464)
        );

        System.out.println(rivers.stream().takeWhile(r -> r.getLength() < 6000).count());
        System.out.println(rivers.stream().takeWhile(r -> r.getLength() > 6000).count());
        System.out.println(rivers.stream().dropWhile(r -> r.getLength() < 6000).count());
        System.out.println(rivers.stream().dropWhile(r -> r.getLength() > 6000).count());
    }
}

class River {
    private final String name;
    private final long length;

    public River(String name, long length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public long getLength() {
        return length;
    }
}


