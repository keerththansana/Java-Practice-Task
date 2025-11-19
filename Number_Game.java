import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundCounter = 0;

        while (true) {
            // Specify the range (1 to 100)
            int minRange = 1;
            int maxRange = 100;

            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int maxAttempts = 5;
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");

            while (attempts < maxAttempts) {
                attempts++;

                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    totalScore += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please guess within the specified range.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Sorry, your guess is too low. The correct number is higher.");
                } else {
                    System.out.println("Sorry, your guess is too high. The correct number is lower.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: "
                            + randomNumber);
                }
            }

            roundCounter++;

            System.out.println("Your score for this round: " + (maxAttempts - attempts));

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing!");
        System.out.println("Total rounds played: " + roundCounter);
        System.out.println("Your total score: " + totalScore);

        scanner.close();
    }
}
