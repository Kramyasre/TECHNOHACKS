import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            // Generate a random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1;
            int userGuess = 0;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100. Can you guess it?");
            // Loop until the user guesses the correct number
            while (userGuess != numberToGuess) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                
                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + numberToGuess);
                }
            }
        }
    }
}
