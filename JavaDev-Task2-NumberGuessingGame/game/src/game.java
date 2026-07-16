import java.util.Random;
import java.util.Scanner;

public class game {

    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    int highestScore = 0;
    int round = 1;

    public void gameDisplay() {

        while (true) {

            System.out.println("\n==============================");
            System.out.println("     NUMBER GUESSING GAME");
            System.out.println("==============================");
            System.out.println("1. Start Game");
            System.out.println("2. View Highest Score");
            System.out.println("3. Reset Highest Score");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    startGame();
                    break;

                case 2:
                    viewHighestScore();
                    break;

                case 3:
                    resetHighestScore();
                    break;

                case 4:
                    System.out.println("Thank you for playing!");
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    public void startGame() {

        boolean playAgain = true;

        while (playAgain) {

            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\n========== ROUND " + round + " ==========");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess (1-100): ");
                int userGuess = sc.nextInt();

                attempts++;

                if (userGuess == randomNumber) {

                    guessed = true;
                    System.out.println("Correct! You guessed the number.");

                    int score = maxAttempts - attempts + 1;

                    if (score > highestScore) {
                        highestScore = score;
                    }

                    System.out.println("You guessed it in " + attempts + " attempts.");
                    break;
                }

                else if (userGuess < randomNumber) {
                    System.out.println("Too Low!");
                }

                else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\nYou Lost!");
                System.out.println("Correct Number was: " + randomNumber);
            }

            System.out.println("Round " + round + " completed.");

            round++;

            System.out.print("\nPlay Again? (Y/N): ");
            char choice = sc.next().charAt(0);

            if (choice != 'Y' && choice != 'y') {
                playAgain = false;
            }
        }
    }

    public void viewHighestScore() {

        System.out.println("Highest Score: " + highestScore);
    }

    public void resetHighestScore() {

        highestScore = 0;
        System.out.println("Highest Score Reset Successfully.");
    }
}
