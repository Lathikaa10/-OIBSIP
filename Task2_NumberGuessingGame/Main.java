import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int number = rand.nextInt(100) + 1; // 1 to 100
        int guess;
        int attempts = 0;
        System.out.println("🎯 Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");
        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess > number) {
                System.out.println("📉 Too High!");
            }
            else if (guess < number) {
                System.out.println("📈 Too Low!");
            }
            else {
                System.out.println("🎉 Correct! You guessed it!");
                System.out.println("Attempts: " + attempts);
            }
        } while (guess != number);

        sc.close();
    }
