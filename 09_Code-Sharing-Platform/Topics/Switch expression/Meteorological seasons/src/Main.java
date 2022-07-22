import java.util.Scanner;

enum Seasons { SPRING, SUMMER, AUTUMN, WINTER }

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Seasons season = Seasons.valueOf(scanner.nextLine());

        int temperature = switch (season) {
            case SPRING, AUTUMN -> 20;
            case SUMMER -> 37;
            case WINTER -> 1;
            default -> throw new IllegalStateException("Invalid number of Seasons.");
        };

        System.out.println(temperature);
    }
}