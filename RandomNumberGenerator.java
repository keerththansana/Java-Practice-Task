
import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        // Specify the range (1 to 100)
        int minRange = 1;
        int maxRange = 100;

        // Create a Random object
        Random random = new Random();

        // Generate a random number within the specified range
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        // Print the generated random number
        System.out.println("Random Number: " + randomNumber);
    }
}
