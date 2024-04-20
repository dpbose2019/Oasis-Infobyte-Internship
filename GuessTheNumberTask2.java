import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    private static final int MAX_ATTEMPTS = 7;
    private static final int MAX_ROUNDS = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            System.out.println("Round " + round + " of " + MAX_ROUNDS);
            int numberToGuess = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attempts = 0;

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (1-100): ");
                int guess = scanner.nextInt();
                if(guess < 1 || guess > 100){
                    System.err.println("Invalid Number");
                }
                else{

                    attempts++;
    
                    if (guess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the number.");
                        score += MAX_ATTEMPTS - attempts;
                        break;
                    } else if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Sorry, you didn't guess the number. The number was " + numberToGuess + ".");
            }
        }

        System.out.println("Game Over! Your final score is: " + score);
        scanner.close();
    }
}
