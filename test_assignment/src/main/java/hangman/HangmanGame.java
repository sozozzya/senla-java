package hangman;

import java.util.*;

public class HangmanGame {
    private static final String[] WORDS = {
            "программа", "java", "компьютер", "игра", "виселица", "алгоритм", "разработка"
    };

    private static final int MAX_LIVES = 6;

    private final String secretWord;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int lives;

    public HangmanGame() {
        Random random = new Random();
        this.secretWord = WORDS[random.nextInt(WORDS.length)];
        this.lives = MAX_LIVES;
    }

    public void play(Scanner scanner) {
        System.out.println("\nДобро пожаловать в игру \"Виселица\"!");
        System.out.println("Попробуйте угадать слово по буквам.");
        System.out.println("У вас " + lives + " жизней.");

        while (lives > 0 && !isWordGuessed()) {
            printWordState();
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Введите одну букву!");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("Вы уже пробовали эту букву!");
                continue;
            }

            guessedLetters.add(guess);

            if (secretWord.indexOf(guess) >= 0) {
                System.out.println("Есть такая буква!");
            } else {
                lives--;
                System.out.println("Такой буквы нет. Осталось жизней: " + lives);
                printHangman();
            }
        }

        if (isWordGuessed()) {
            System.out.println("\nПоздравляем! Вы угадали слово: " + secretWord);
        } else {
            System.out.println("\nВы проиграли! Загаданное слово было: " + secretWord);
        }
    }

    private void printWordState() {
        for (char c : secretWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                System.out.print(c + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private boolean isWordGuessed() {
        for (char c : secretWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private void printHangman() {
        String[] stages = {
                """
                   +---+
                   |   |
                   O   |
                  /|\\  |
                  / \\  |
                       |
                 =========
                """,
                """
                   +---+
                   |   |
                   O   |
                  /|\\  |
                  /    |
                       |
                 =========
                """,
                """
                   +---+
                   |   |
                   O   |
                  /|\\  |
                       |
                       |
                 =========
                """,
                """
                   +---+
                   |   |
                   O   |
                  /|   |
                       |
                       |
                 =========
                """,
                """
                   +---+
                   |   |
                   O   |
                   |   |
                       |
                       |
                 =========
                """,
                """
                   +---+
                   |   |
                   O   |
                       |
                       |
                       |
                 =========
                """,
                """
                   +---+
                   |   |
                       |
                       |
                       |
                       |
                 =========
                """
        };
        System.out.println(stages[MAX_LIVES - lives]);
    }
}
