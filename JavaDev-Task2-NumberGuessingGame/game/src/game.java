import java.util.Scanner;

public class game{
    int HighestScore = 0;
    int menus=0;
    public void gamedisplay(){

        while(menus != 4) {
            System.out.println("================================");
        System.out.println("   Number Guessing Game   ");
        System.out.println("================================");
        System.out.println("   1. Start Game   ");
        System.out.println("   2. View Highest Score   ");
        System.out.println("   3. Reset Highest Score   ");
        System.out.println("   4. Exit   ");

        System.out.print("Enter your choice: ");
        int menu = new Scanner(System.in).nextInt();
        switch(menu) {
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
                System.out.println("Exiting the game. Goodbye!");
                break;

            default:
                System.out.println("Invalid input. Please try again.");
                break; 
        }
        
        }
    }

    public void startGame() {
        System.out.println("Starting the game...");
        int userGuess = new Scanner(System.in).nextInt();
        int randomNumber = (int) (Math.random() * 100) + 1;

        
        int attempts = 0;
        while(userGuess != randomNumber && attempts <= 7) {
            attempts++;

            if(userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
            System.out.println("Attempts left: " + (7 - attempts));
            userGuess = new Scanner(System.in).nextInt();

            if(attempts == 7) {
                System.out.println("Play Again? (Y/N)");
                String playAgain = new Scanner(System.in).nextLine();
                if(playAgain.equalsIgnoreCase("Y")) {
                    startGame();
                } else {
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                }
                break;
            }
        }
        if(userGuess == randomNumber) {
            HighestScore = 7 - attempts;
            System.out.println("Correct! You guessed the number: " + randomNumber);
        } else {
            System.out.println("Sorry, the correct number was: " + randomNumber);
        }
    }

    public void viewHighestScore() {
        System.out.println("Highest Score: " + HighestScore);
    }

    public void resetHighestScore() {
        HighestScore = 0;
        System.out.println("Highest score has been reset.");
    }
}