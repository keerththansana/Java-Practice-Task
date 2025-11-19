import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame4 {
    public static void main(String[] args) {
        // Specify the range (1 to 100)
        int minRange = 1;
        int maxRange = 100;

        // Create a Random object
        Random random = new Random();

        // Generate a random number within the specified range
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Set the maximum number of attempts
        int maxAttempts = 5;

        // Initialize a variable to track the number of attempts
        int attempts = 0;

        // Loop until the user guesses the correct number or reaches the maximum
        // attempts
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
                break; // Exit the loop if the guess is correct
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
            System.out.println(
                    "Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
        }

        // Close the Scanner to avoid resource leaks
        scanner.close();
    }
}
