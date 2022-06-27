package bullscows;

import java.util.Random;
import java.util.Scanner;

public class BullsCows {

    private final Scanner scanner = new Scanner(System.in);
    private int numToGuess;
    private int inputNumber;

    public void startGame() {
        generateNumToGuess();
        getInputNumber();
        playBullsAndCows(inputNumber);
    }

    private void getInputNumber() {
        inputNumber = scanner.nextInt();
    }

    private void generateNumToGuess() {

        int lower = 1111;
        int upper = 9999;
        Random random = new Random();
        int intervalLength = upper - lower + 1;

        numToGuess = random.nextInt(intervalLength) + lower;
    }

    private void playBullsAndCows(int number) {

        int bulls = 0;
        int cows = 0;

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

        if (bulls == 0 && cows == 0)
            System.out.printf("Grade: None. The secret code is %d.", numToGuess);
        else
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %d.", bulls, cows, numToGuess);
    }
}
