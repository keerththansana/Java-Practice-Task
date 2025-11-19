import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame1 {
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

        // Prompt the user to enter their guess
        System.out.println("Guess the number between " + minRange + " and " + maxRange + ": ");
        int userGuess = scanner.nextInt();

        // Check if the user's guess is correct
        if (userGuess == randomNumber) {
            System.out.println("Congratulations! Your guess is correct.");
        } else {
            System.out.println("Sorry, the correct number was: " + randomNumber);
        }

        // Close the Scanner to avoid resource leaks
        scanner.close();
    }
}
