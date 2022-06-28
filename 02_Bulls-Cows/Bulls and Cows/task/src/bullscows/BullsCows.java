package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BullsCows {

    private final Scanner scanner = new Scanner(System.in);
    private long numToGuess;
    private int turns = 0;
    boolean gameOn = true;

    public void startGame() {
        generateNumToGuess();
        System.out.println("Okay, let's start a game!");
        // System.out.println("Number: " + numToGuess);
        do {
            System.out.printf("Turn %d:\n", ++turns);
            long inputNumber = getInputNumber(); // numero del usuario
            List<Integer> bullsCows = checkInputNumber(inputNumber);
            printBullsAndCows(bullsCows);
        } while (gameOn);
        System.out.println("Congratulations! You guessed the secret code.");
    }

    private long getInputNumber() {
        return scanner.nextLong();
    }

    private void generateNumToGuess() {

        NumGenerator numGenerator = new NumGenerator();
        numToGuess = numGenerator.setSecretCode();
    }

    private List<Integer> checkInputNumber(long number) {

        int bulls = 0;
        int cows = 0;
        List<Integer> numbers = new ArrayList<>();

        char[] digitsToGuess = String.valueOf(numToGuess).toCharArray();
        char[] answer = String.valueOf(number).toCharArray();

        for (int i = 0; i < digitsToGuess.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (i == j && digitsToGuess[i] == answer[j])
                    bulls++;
                else if (i != j && digitsToGuess[i] == answer[j])
                    cows++;
            }
        }

        numbers.add(bulls);
        numbers.add(cows);
        return numbers;
    }

    private void printBullsAndCows(List<Integer> bullsCows) {

        int bulls = bullsCows.get(0);
        int cows = bullsCows.get(1);
        StringBuilder outputString = new StringBuilder("Grade: ");
        String outBulls = bulls > 1 ? "bulls" : bulls == 1 ? "bull" : "bulls";
        String outCows = cows > 1 ? "cows" : cows == 1 ? "cow" : "";

        outputString.append(bulls)
                .append(" ")
                .append(outBulls)
                .append(" ");

        if (cows != 0)
            outputString.append(cows)
                    .append(" ")
                    .append(outCows);

        String strToGuess = String.valueOf(numToGuess);
        if (bulls == strToGuess.length())
            gameOn = false;
        System.out.println(outputString);
    }
}
