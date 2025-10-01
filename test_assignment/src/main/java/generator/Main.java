package generator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordGenerator generator = new PasswordGenerator();

        boolean generateAgain = true;
        while (generateAgain) {
            generator.run(scanner);

            System.out.print("\nХотите сгенерировать ещё один пароль? (да/нет): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (!answer.equals("да")) {
                generateAgain = false;
                System.out.println("Спасибо! До свидания!");
            }
        }

        scanner.close();
    }
}
