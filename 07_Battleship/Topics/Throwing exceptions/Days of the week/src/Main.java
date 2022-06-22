import java.util.*;

public class Main {

    public static String getDayOfWeekName(int number) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<String> days = List.of("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        if (!numbers.contains(number)) {
            throw new IllegalArgumentException();
        } else {
            return days.get(number - 1);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        try {
            System.out.println(getDayOfWeekName(dayNumber));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}