package com.example.Task1;
import java.util.Scanner;
import java.util.Random;
public class Task1 {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            int totalRounds = 0;
            int totalScore = 0;
            String playAgain;

            System.out.println("Welcome to the number guessing game!");

            do {

                int targetNumber = random.nextInt(100) + 1;
                int maxAttempts = 7;
                int attempts = 0;
                boolean isGuessed = false;

                System.out.println("\nI have picked a number between 1 and 100.");
                System.out.println("You have " + maxAttempts + " attempts to guess it.");

                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == targetNumber) {
                        System.out.println("Congratulations! You achieved to guess the correct number.");
                        isGuessed = true;
                        totalScore += (maxAttempts - attempts + 1);
                        break;
                    } else if (guess > targetNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Too low! Try again.");
                    }
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                }

                if (!isGuessed) {
                    System.out.println("\nYou've used all attempts. The number was: " + targetNumber);
                }

                totalRounds++;
                System.out.println("\nYour current score: " + totalScore);


                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next();

            } while (playAgain.equalsIgnoreCase("yes"));

            System.out.println("\nThanks for playing!");
            System.out.println("You played " + totalRounds + " rounds with a total score of " + totalScore + ".");

        }
    }


