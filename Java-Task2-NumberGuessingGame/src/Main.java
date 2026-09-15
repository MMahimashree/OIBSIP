import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 1;
        int totalScore = 0;

        System.out.println("======================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("======================================");

        boolean playAgain = true;

        while (playAgain) {

            System.out.println("\nRound " + round);
            System.out.println("Choose Difficulty:");
            System.out.println("1. Easy   (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard   (1-200, 5 attempts)");

            int difficulty;

            while (true) {
                System.out.print("Enter your choice (1-3): ");

                if (scanner.hasNextInt()) {
                    difficulty = scanner.nextInt();

                    if (difficulty >= 1 && difficulty <= 3) {
                        break;
                    }
                } else {
                    scanner.next();
                }

                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

            int maxNumber;
            int maxAttempts;

            if (difficulty == 1) {
                maxNumber = 50;
                maxAttempts = 10;
            } else if (difficulty == 2) {
                maxNumber = 100;
                maxAttempts = 7;
            } else {
                maxNumber = 200;
                maxAttempts = 5;
            }

            int secretNumber = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and " + maxNumber + ".");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {

                    System.out.println("Correct! 🎉");
                    System.out.println("You guessed the number in "
                            + attempts + " attempt(s).");

                    totalScore++;
                    guessedCorrectly = true;
                    break;

                } else if (guess > secretNumber) {

                    System.out.println("Too High!");
                    System.out.println("Attempts remaining: "
                            + (maxAttempts - attempts));

                } else {

                    System.out.println("Too Low!");
                    System.out.println("Attempts remaining: "
                            + (maxAttempts - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou Lost! 😢");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.println("\n--------------------------------------");
            System.out.println("Round " + round + " Summary");
            System.out.println("Attempts used: " + attempts);
            System.out.println("Result: "
                    + (guessedCorrectly ? "Won" : "Lost"));
            System.out.println("--------------------------------------");

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("yes")
                    || answer.equalsIgnoreCase("y")) {

                round++;

            } else {
                playAgain = false;
            }
        }

        System.out.println("\n======================================");
        System.out.println("             GAME OVER");
        System.out.println("Rounds Played: " + round);
        System.out.println("Rounds Won: " + totalScore);
        System.out.println("======================================");

        scanner.close();
    }
}