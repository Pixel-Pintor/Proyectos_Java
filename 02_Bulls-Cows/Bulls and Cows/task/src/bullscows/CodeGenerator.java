package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CodeGenerator {

    private final StringBuilder ERROR =
            new StringBuilder("Error: can't generate a secret " +
                    "number with a length of  because there aren't " +
                    "enough unique digits.");
    private final Scanner scanner = new Scanner(System.in);
    private String secretCode;
    private final List<Character> ranges = new ArrayList<>();

    public String setSecretCode() {
        int lengthCode;
        int possibleSymbols;
        boolean valid = false;
        createSymbolList();
        do {
            lengthCode = getCodeLength();
            if (lengthCode > 36 || lengthCode < 1) {
                ERROR.insert(55, lengthCode);
                System.out.println(ERROR);
            } else {
                possibleSymbols = getPossibleSymbols();
                printCodePrepared(lengthCode, possibleSymbols);
                generateSecretCode(lengthCode, possibleSymbols);
                valid = true;
            }
        } while (!valid);
        return secretCode;
    }

    private void createSymbolList() {
        for (char c = '0'; c <= '9'; c++) {
            ranges.add(c);
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            ranges.add(c);
        }
    }

    private int getCodeLength() {
        System.out.println("Input the length of the secret code:");
        return scanner.nextInt();
    }

    private int getPossibleSymbols() {
        System.out.println("Input the number of possible symbols in the code:");
        return scanner.nextInt();
    }

    private void printCodePrepared(int length, int symbols) {
        StringBuilder secretOutput = new StringBuilder("The secret is prepared: ");
        secretOutput.append("*".repeat(length));
        if (symbols <= 10) {
            secretOutput.append(" (0-")
                    .append(ranges.get(symbols - 1))
                    .append(").");
        } else {
            secretOutput.append(" (0-9, a-")
                    .append(ranges.get(symbols - 1))
                    .append(").");
        }
        System.out.println(secretOutput);
    }

    private void generateSecretCode(int length, int symbols) {

        int randomIndex;
        char symbolChar;
        StringBuilder codeBuilder = new StringBuilder();
        ArrayList<Character> finalCode = new ArrayList<>();
        Random random = new Random();
        int index = 0;

        while (index < length) {
            randomIndex = random.nextInt(symbols - 1);
            symbolChar = ranges.get(randomIndex);
            if (!finalCode.contains(symbolChar)) {
                finalCode.add(symbolChar);
                index++;
            }
        }

        for (char num : finalCode) {
            codeBuilder.append(num);
        }

        secretCode = codeBuilder.toString();
    }
}