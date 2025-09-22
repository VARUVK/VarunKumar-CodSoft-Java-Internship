import java.util.*;

public class Task1NumberGuessingGame {
    // Constants
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;    // Total score
        int roundsPlayed = 0;  // Round count

        System.out.println("Welcome to the Ultimate Number Guessing Game!");

        while (true) {
            roundsPlayed++;
            int roundScore = playGame(scanner); // One round
            totalScore += roundScore;           // Update score
            
            // Show results
            System.out.println("\nRound " + roundsPlayed + " Score: " + roundScore);
            System.out.println("Total Score: " + totalScore);
            
            // Play again?
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                break; // Exit game
            }
        }
        
        // Final output
        System.out.println("\nThanks for playing! Final score: " + totalScore + " over " + roundsPlayed + " rounds.");
        scanner.close();
    }

    // Play one round
    private static int playGame(Scanner scanner) {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER; // Random number
        int attempts = 0;

        System.out.println("\nI've selected a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

        // Attempts loop
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            
            // Input check
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Please enter a valid guess.");
                scanner.next();
                System.out.print("Enter your guess: ");
            }
            
            int userGuess = scanner.nextInt();
            attempts++;

            // Guess check
            if (userGuess == randomNumber) {
                System.out.println("🌟 You got it! It took you " + attempts + " attempts.");
                return MAX_ATTEMPTS - attempts + 1; // Score
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Attempts left: " + (MAX_ATTEMPTS - attempts));
            } else {
                System.out.println("Too high! Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        // Out of tries
        System.out.println("❌ You've run out of attempts. The correct number was " + randomNumber + ".");
        return 0; // No score
    }
}
