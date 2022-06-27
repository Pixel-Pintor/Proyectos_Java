package bullscows;

public class Main {
    public static void main(String[] args) {
        BullsCows newGame = new BullsCows();
        newGame.startGame();
    }

}

/*
STAGE 2
- The program should create a 4 digit secret code, and the player should
try to guess it on the first try.
- The programa should give a grade to evaluate how accurate the player
was
- As you remember, a correctly guesses digits is a cow, and if its position
is also correct, then it is a bull.
- After the player tries to guess the secret code, the program should grade
the attempt and finish the execution.
Objectives
1. Your program should take a 4-digit number as an input
2. Use a predefined 4-digit code and grade the answer that was input.
You can do it digit by digit.
- The grade is considered correct if it contains number-and-word pairs
(like X bulls and Y cows) that give the correct information. If the answer
doesn't contain any bulls and cows, you should output None.
 */
