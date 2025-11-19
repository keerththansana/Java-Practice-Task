import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame3 {
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

        // Initialize a variable to track whether the user has guessed correctly
        boolean guessedCorrectly = false;

        // Loop until the user guesses the correct number
        while (!guessedCorrectly) {
            // Prompt the user to enter their guess
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ": ");
            int userGuess = scanner.nextInt();

            // Compare the user's guess with the generated number
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! Your guess is correct.");
                guessedCorrectly = true; // Set the flag to exit the loop
            } else if (userGuess < minRange || userGuess > maxRange) {
                System.out.println("Please guess within the specified range.");
            } else if (userGuess < randomNumber) {
                System.out.println("Sorry, your guess is too low. The correct number is higher.");
            } else {
                System.out.println("Sorry, your guess is too high. The correct number is lower.");
            }
        }

        // Close the Scanner to avoid resource leaks
        scanner.close();
    }
}
