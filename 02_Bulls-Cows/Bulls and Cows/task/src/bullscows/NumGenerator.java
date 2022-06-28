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
    private final StringBuilder SUCCESS = new StringBuilder("The random secret number is .");
    private final Scanner scanner = new Scanner(System.in);
    private long secretCode;

    public void startNumberGenerator() {
        int lengthCode = getCodeLength();
        if (lengthCode > MAX || lengthCode < 1) {
            ERROR.insert(55, lengthCode);
            System.out.println(ERROR);
        } else {
            generateSecretCode(lengthCode);
            SUCCESS.insert(28, secretCode);
            System.out.println(SUCCESS);
        }
    }

    private int getCodeLength() {
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