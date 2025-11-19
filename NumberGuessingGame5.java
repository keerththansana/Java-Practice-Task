import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame5 {
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Outer loop for multiple rounds
        while (true) {
            // Specify the range (1 to 100)
            int minRange = 1;
            int maxRange = 100;

            // Create a Random object
            Random random = new Random();

            // Generate a random number within the specified range
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            // Set the maximum number of attempts
            int maxAttempts = 5;

            // Initialize a variable to track the number of attempts
            int attempts = 0;

            // Inner loop for a single round
            while (attempts < maxAttempts) {
                // Increment the attempts counter
                attempts++;

                // Prompt the user to enter their guess
                System.out.println(
                        "Attempt " + attempts + ": Guess the number between " + minRange + " and " + maxRange + ": ");
                int userGuess = scanner.nextInt();

                // Compare the user's guess with the generated number
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    break; // Exit the inner loop if the guess is correct
                } else if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please guess within the specified range.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Sorry, your guess is too low. The correct number is higher.");
                } else {
                    System.out.println("Sorry, your guess is too high. The correct number is lower.");
                }
            }

            // Check if the user used all attempts without guessing correctly
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: "
                        + randomNumber);
            }

            // Ask the user if they want to play again
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            // Exit the outer loop if the user doesn't want to play again
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        // Close the Scanner to avoid resource leaks
        scanner.close();
    }
}
