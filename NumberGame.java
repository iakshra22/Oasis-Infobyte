package numbergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameCode {

    private int minRange = 1;
    private int maxRange = 100;
    private int maxAttempts = 5;
    private int totalRounds = 3;
    private int totalScore = 0;
    private String playerName;

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    private final List<String> roundHistory = new ArrayList<>();

  
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";

    public void startGame() {
        getPlayerName();
        chooseDifficulty();
        showWelcomeMessage();

        for (int round = 1; round <= totalRounds; round++) {
            playRound(round);
            showScoreboard(round);
        }

        showFinalResults();
    }

 
    private void getPlayerName() {
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
            playerName = "Player";
        }
    }

    private void chooseDifficulty() {
        System.out.println("\nChoose Difficulty Level:");
        System.out.println("1. Easy (1-50, 7 attempts)");
        System.out.println("2. Medium (1-100, 5 attempts)");
        System.out.println("3. Hard (1-200, 4 attempts)");
        System.out.print("Your choice is: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            choice = 2; 
        }

        switch (choice) {
            case 1 -> {
                maxRange = 50;
                maxAttempts = 7;
            }
            case 3 -> {
                maxRange = 200;
                maxAttempts = 4;
            }
            default -> {
                maxRange = 100;
                maxAttempts = 5;
            }
        }
    }

 
    private void showWelcomeMessage() {
        System.out.println("🎯 WELCOME " + playerName.toUpperCase() + " TO THE GUESS THE NUMBER GAME");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
        System.out.println(" Here are the Rules you have to follow:");
        System.out.println("1️. Guess the number between " + minRange + " and " + maxRange);
        System.out.println("2️. You have only " + maxAttempts + " attempts per round.");
        System.out.println("3️. Score more by guessing quickly.");
        System.out.println("4️. Game has " + totalRounds + " rounds.");
        System.out.println("===========================================\n");
    }


    private void playRound(int roundNumber) {
        int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
        int attemptsUsed = 0;
        boolean guessedCorrectly = false;

        System.out.println(CYAN + "\n📢 ROUND " + roundNumber + " — START!" + RESET);
        while (attemptsUsed < maxAttempts) {
            System.out.print("Attempt " + (attemptsUsed + 1) + "/" + maxAttempts + " → Enter your guess: ");
            int guess;
            try {
                guess = Integer.parseInt(scanner.nextLine().trim());
                if (guess < minRange || guess > maxRange) {
                    System.out.println(RED + "Out of range! Enter between " + minRange + " and " + maxRange + "." + RESET);
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Invalid input! Please enter a valid number." + RESET);
                continue;
            }

            attemptsUsed++;

            if (guess == numberToGuess) {
                guessedCorrectly = true;
                int pointsEarned = (maxAttempts - attemptsUsed + 1) * 10;
                totalScore += pointsEarned;
                roundHistory.add("Round " + roundNumber + ":  Guessed in " + attemptsUsed + " attempts | +" + pointsEarned + " points");
                System.out.println(GREEN + "Correct! You earned " + pointsEarned + " points." + RESET);
                break;
            } else if (guess < numberToGuess) {
                System.out.println(YELLOW + "Too Low! Try higher ⬆" + RESET);
            } else {
                System.out.println(YELLOW + "Too High! Try lower ⬇" + RESET);
            }
        }

        if (!guessedCorrectly) {
            roundHistory.add("Round " + roundNumber + ": Failed! Number was " + numberToGuess);
            System.out.println(RED + "\nNo more attempts! The correct number was: " + numberToGuess + RESET);
        }
    }

    private void showScoreboard(int currentRound) {
        System.out.println("\n" + PURPLE + "SCOREBOARD AFTER ROUND " + currentRound + RESET);
        System.out.println("─────────────────────────────────────────────");
        for (String record : roundHistory) {
            System.out.println(record);
        }
        System.out.println("─────────────────────────────────────────────");
        System.out.println("Total Score: " + totalScore);
        System.out.println("─────────────────────────────────────────────\n");
    }

    private void showFinalResults() {
        System.out.println(PURPLE + "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("GAME OVER");
        System.out.println("Player: " + playerName);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Rounds Played: " + totalRounds);
        if (totalScore >= (totalRounds * maxAttempts * 10) * 0.8) {
            System.out.println("Excellent Performance!");
        } else if (totalScore >= (totalRounds * maxAttempts * 10) * 0.5) {
            System.out.println("Good Job!");
        } else {
            System.out.println("Keep Practicing!");
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
    }

    public static void main(String[] args) {
        new GameCode().startGame();
    }
}











