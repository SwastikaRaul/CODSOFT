import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame { public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    boolean playAgain = true;
    int totalRoundsWon = 0;

    System.out.println("Welcome to the Number Guessing Game!");

    while (playAgain) {
        int randomNumber = random.nextInt(100) + 1; // Generates a number between 1 and 100
        int attempts = 0;
        int maxAttempts = 7;
        boolean guessedCorrectly = false;
    }
}

}
