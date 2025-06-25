package Casino;

import java.util.Scanner;

public class MainCasino {
    private static int playerBank = 100;
    private static int casinoBank = 500;
    private static final int MIN_BET = 10;
    private static final int LIFE_OR_DEATH_MAX = 12;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean wantsToKeepPlaying = true;

        while (playerBank > MIN_BET && wantsToKeepPlaying) {
            System.out.println("How much do you want to bet? Minimum is 10 euros:");
            int bet = scanner.nextInt();

            while (bet < MIN_BET || bet > playerBank) {
                System.out.println("Enter a valid bet:");
                bet = scanner.nextInt();
            }

            playerBank -= bet;
            System.out.println("Bet placed. Your new balance is €" + playerBank);

            boolean rollAgain;
            do {
                int roll1 = (int) (Math.random() * 6) + 1;
                int roll2 = (int) (Math.random() * 6) + 1;
                int result = roll1 + roll2;
                rollAgain = false;

                if (result == 7 || result == 11) {
                    System.out.println("You win!!");
                    int winnings = bet * 2;
                    playerBank += winnings;
                    casinoBank -= winnings;
                    System.out.println("Your new balance is €" + playerBank);
                } else if (result == 2 || result == 3 || result == 10 || result == 12) {
                    System.out.println("You lost.");
                    casinoBank += bet;
                    System.out.println("Your new balance is €" + playerBank);
                } else {
                    System.out.println("Undetermined result with " + result + ". Rolling again with no additional bet.");
                    rollAgain = true;
                }
            } while (rollAgain);

            if (playerBank > MIN_BET) {
                System.out.println("Do you want to keep playing? (yes/no)");
                scanner.nextLine(); // Clear buffer
                String option = scanner.nextLine();
                wantsToKeepPlaying = option.equalsIgnoreCase("yes");
            }
        }

        if (playerBank <= MIN_BET) {
            System.out.println("Do you want to play Life or Death? You bet everything and choose a number between 2 and 12. If you guess right, you win the entire casino bank. If not, you lose it all. Do you want to play? (yes/no)");
            scanner.nextLine(); // Clear buffer
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("yes")) {
                System.out.println("Let's go. Guess the number:");
                int lifeOrDeathNumber = (int) (Math.random() * LIFE_OR_DEATH_MAX) + 1;
                int guessedNumber = scanner.nextInt();
                if (guessedNumber == lifeOrDeathNumber) {
                    System.out.println("You guessed correctly! You win all the casino's money.");
                    playerBank += casinoBank;
                    casinoBank = 0;
                } else {
                    System.out.println("Too bad, you lost.");
                    casinoBank += playerBank;
                    playerBank = 0;
                }
            } else {
                System.out.println("Alright, maybe next time.");
            }
        }

        System.out.println("Game over. Your final balance is €" + playerBank + " and the casino's balance is €" + casinoBank);
    }
}
