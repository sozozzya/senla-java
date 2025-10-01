package hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;
        while (playAgain) {
            HangmanGame game = new HangmanGame();
            game.play(scanner);

            System.out.print("\nХотите сыграть ещё раз? (да/нет): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (!answer.equals("да")) {
                playAgain = false;
                System.out.println("Спасибо за игру! До свидания!");
            }
        }

        scanner.close();
    }
}
