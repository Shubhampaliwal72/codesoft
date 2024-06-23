import java.util.Random;
import java.util.Scanner;

public class task1 {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I have selected a number between " + MIN + " and " + MAX + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    int score = MAX_ATTEMPTS - attemptsLeft;
                    totalScore += score;
                    roundsPlayed++;
                    System.out.println("Congratulations! You guessed the number in " + score + " attempts.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                if (!guessedCorrectly && attemptsLeft == 0) {
                    System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess + ".");
                } else if (guessedCorrectly) {
                    break;
                }

                System.out.println("You have " + attemptsLeft + " attempts left.");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
        if (roundsPlayed > 0) {
            double averageScore = (double) totalScore / roundsPlayed;
            System.out.println("You played " + roundsPlayed + " rounds.");
            System.out.println("Your average score per round is: " + averageScore);
        } else {
            System.out.println("You didn't complete any rounds.");
        }

        scanner.close();
    }
}
