package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean convertAgain = true;

        while (convertAgain) {
            CurrencyConverter converter = new CurrencyConverter();
            converter.run();

            System.out.print("\nХотите сделать ещё одну конвертацию? (да/нет): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("да")) {
                convertAgain = false;
                System.out.println("Спасибо за использование конвертера! До свидания!");
            }
        }

        scanner.close();
    }
}
