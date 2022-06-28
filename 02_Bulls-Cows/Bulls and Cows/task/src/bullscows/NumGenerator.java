package bullscows;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumGenerator {

    private final int MAX = 10;
    private final StringBuilder ERROR =
            new StringBuilder("Error: can't generate a secret " +
                    "number with a length of  because there aren't " +
                    "enough unique digits.");
    private final Scanner scanner = new Scanner(System.in);
    private long secretCode;

    public long setSecretCode() {
        int lengthCode;
        boolean valid = false;
        do {
            lengthCode = getCodeLength();
            if (lengthCode > MAX || lengthCode < 1) {
                ERROR.insert(55, lengthCode);
                System.out.println(ERROR);
            } else {
                generateSecretCode(lengthCode);
                valid = true;
            }
        } while (!valid);
        return secretCode;
    }

    private int getCodeLength() {
        System.out.println("Please, enter the secret code's length:");
        return scanner.nextInt();
    }

    private void generateSecretCode(int lengthCode) {

        int number;
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> finalNum = new ArrayList<>();
        Random random = new Random();
        int ZERO = 0;
        int index = ZERO;

        while (index < lengthCode) {
            number = random.nextInt(MAX);
            if (index == ZERO && number == ZERO) {
                while (number == ZERO) {
                    number = random.nextInt(MAX);
                }
                finalNum.add(number);
                index++;
            } else if (!finalNum.contains(number)) {
                finalNum.add(number);
                index++;
            }
        }

        for (int num : finalNum) {
            stringBuilder.append(num);
        }

        secretCode = Long.parseLong(stringBuilder.toString());
    }
}