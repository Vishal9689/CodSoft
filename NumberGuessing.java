import java.lang.*;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    // Function to play a single round of the game
    public static int playRound() {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;  // Random number between 1 and 100
        int attemptsLeft = 10;
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to codsoft the Number Guessing Game !");
        System.out.println("Try to guess the number between 1 and 100.");
        System.out.println("You have " + attemptsLeft + " attempts.");

        // Loop to let the user guess
        while (attemptsLeft > 0) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            attemptsLeft--;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                return attempts; // Return the number of attempts it took to guess correctly
            }

            System.out.println("You have " + attemptsLeft + " attempts left.");
        }

        System.out.println("Sorry, you're out of attempts. The correct number was " + numberToGuess + ".");
        return attempts;  // Return the number of attempts used even if they fail
    }

    // Function to play the game with multiple rounds
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int roundsPlayed = 0;

        while (true) {
            roundsPlayed++;
            int attemptsUsed = playRound();
            totalScore += attemptsUsed;

            // Ask if the player wants to play another round
            System.out.print("Do you want to play another round? (y/n): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("y")) {
                break;  // Exit the loop if the user doesn't want to play again
            }
        }

        System.out.println("Game Over! You played " + roundsPlayed + " rounds.");
        System.out.println("Your total score is " + totalScore + " attempts.");
    }

    // Main function to start the game
    public static void main(String[] args) {
        playGame();
    }
}