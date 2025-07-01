import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int round = 1;

        System.out.println("Welcome to the Number Guessing Game...");
        System.out.println("Instructions for playing the game:");
        System.out.println("-> Guess the number between 1 and 100.");
        System.out.println("-> You have a maximum of 5 attempts in each round.");
        System.out.println("-> You earn more points for guessing in fewer attempts.\n");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + round + " starts!");
            while (attempts < 5) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of 5): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    hasGuessedCorrectly = true;
                    int scoreThisRound = 6 - attempts; // Score: 5 for 1st try, 4 for 2nd, etc.
                    totalScore += scoreThisRound;
                    System.out.println("You earned " + scoreThisRound + " points this round.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You ran out of attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Total Score after Round " + round + ": " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            } else {
                round++;
            }
            System.out.println();
        }

        System.out.println("Game Over! Your final score is: " + totalScore);
        System.out.println("Thank you for playing.");
        scanner.close();
    }
}
