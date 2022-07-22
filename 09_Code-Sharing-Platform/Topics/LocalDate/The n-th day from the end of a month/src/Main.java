import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println(LocalDate.of(2018, 3, 2).minusMonths(2));
        System.out.println(LocalDate.ofYearDay(2018, 2));
        System.out.println(LocalDate.of(2018, 1, 1).plusDays(1));
    }
}