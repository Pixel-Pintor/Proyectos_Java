package bullscows;

public class Main {
    public static void main(String[] args) {
        // BullsCows newGame = new BullsCows();
        // newGame.startGame();
        NumGenerator numGenerator = new NumGenerator();
        numGenerator.startNumberGenerator();
    }

}

/*
STAGE 3
- Let's implement the ability to generate a pseudo-random secret number
of a given length.
- If the length is greater than 10, print a warning message and do not generate
a number
- We suggest you use the following algorithm to generate the numbers
long pseudoRandomNumber = System.nanoTime();
- This code saves the nanoseconds elapsed since a certain time to the
pseudoRandomNumber variable, we can assume that this is a random number
- You can generate a secret code by iterating over the pseudoRandomNumber
in the reverse order and adding unique digits
- if the pseudoRandomNumber lack the required number of unique digits,
call System.nanoTime() again and try to generate the secret code again
until you get satisfactory result
- You can use the Character.getNumericValue(char a) method to get an
integer representation of a number
OBJECTIVE
In this stage, your programa should generate a pseudo-random number of a
given length with unique digits and print it. If the lengths is greater
than 10, the programa should print a message containing the word Error.
The secret code may contain any digits from 0 to 9 but only once. The
secret code shouldn't start with a digit 0; for the first digit of the secret
code, use digits from 1 to 9.
 */
