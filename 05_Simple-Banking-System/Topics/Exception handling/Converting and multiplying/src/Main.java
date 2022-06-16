import java.util.Scanner;

class Main {

    private static final int MULTIPLIER = 10;

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            String input = scanner.next();
            try {
                int num = Integer.parseInt(input);
                if (num == 0) {
                    run = false;
                } else {
                    System.out.println(num * MULTIPLIER);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + input);
            }
        }
    }
}