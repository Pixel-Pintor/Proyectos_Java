package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CodeGenerator {

    private final Scanner scanner = new Scanner(System.in);
    private String error;
    private String secretCode;
    private final List<Character> ranges = new ArrayList<>();

    public String setSecretCode() {
        int lengthCode;
        int possibleSymbols;
        createSymbolList();
        lengthCode = getCodeLength();
        if (lengthCode != 0) {
            possibleSymbols = getPossibleSymbols();
            if (possibleSymbols != 0) {
                if (lengthCode > possibleSymbols ) {
                    error = "Error: it's not possible to generate a code " +
                            "with a length of " + lengthCode + " with " +
                            possibleSymbols + " unique symbols.";
                    System.out.println(error);
                    secretCode = "None";
                } else if (possibleSymbols > 36) {
                    error = "Error: maximum number of possible " +
                            "symbols in the code is 36 (0-9, a-z).";
                    System.out.println(error);
                    secretCode = "None";
                } else {
                    printCodePrepared(lengthCode, possibleSymbols);
                    generateSecretCode(lengthCode, possibleSymbols);
                }
            } else {
                secretCode = "None";
            }
        } else {
            secretCode = "None";
        }
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
        String length = scanner.nextLine();
        if (checkValidNumber(length)) {
            return Integer.parseInt(length);
        } else {
            return 0;
        }
    }

    private int getPossibleSymbols() {
        System.out.println("Input the number of possible symbols in the code:");
        String symbols = scanner.nextLine();
        if (checkValidNumber(symbols)) {
            return Integer.parseInt(symbols);
        } else {
            return 0;
        }
    }

    private boolean checkValidNumber(String input) {
        try {
            int division = 2 / Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            error = "Error: \"" + input + "\" isn't a valid number";
            System.out.println(error);
            return false;
        }
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