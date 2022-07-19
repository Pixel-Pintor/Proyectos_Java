package banking.anonymous;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntegerInput() {
        return scanner.nextInt();
    }

    public static String getStringInput() {
        return scanner.next();
    }
}
