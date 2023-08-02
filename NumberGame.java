package numbergame;

import java.util.Scanner;


public class NumberGame {
    public static void main(String args[]) {

        // This method is used to generate a random number between 1 to 100.........
        int originalNumber;

        // initialization of maximum tries and score
        int maxTry = 10;
        int score = 0;

        Scanner sc = new Scanner(System.in);
        String playAgain;

        do {
            System.out.println("Welcome to Number Guessing Game!");
            System.out.println("You have to guess a number between 1 to 100");
            System.out.println("You have maximum 10 chances to guess the correct number");

            originalNumber = 1 + (int) (Math.random() * 100);

            // This for-loop is used to give feedback about guesses and to calculate score
            for (int i = 0; i < maxTry; i++) {

                System.out.print("\n" + "Guess a number: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid integer number.");
                    sc.next(); // consume the non-integer input
                }

                int guessedNumber = sc.nextInt();

                if (guessedNumber == originalNumber) {
                    System.out.println("Congratulations! You've guessed correctly.");
                    score = 100 - (20 * i);
                    break;
                } else if (guessedNumber > originalNumber) {
                    System.out.println("Oops! Your guess was too high.");
                } else {
                    System.out.println("Oops! Your guess was too low.");
                }
            }

            if (score == 0) {
                System.out.println("\n" + "You ran out of attempts. The correct number was: " + originalNumber);
            } else {
                System.out.println("\n" + "Your score: " + score + "/100");
            }

            System.out.print("\n" + "Do you want to play again? (yes/no): ");
            playAgain = sc.next().toLowerCase();
        } while (playAgain.equals("yes"));

        sc.close();
        System.out.println("Thank you for playing!");
    }
}
