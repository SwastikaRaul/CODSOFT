import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
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

            System.out.println("\nA new number has been generated between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;

                // Validate user input
                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalRoundsWon++;
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over! You won " + totalRoundsWon + " rounds.");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
