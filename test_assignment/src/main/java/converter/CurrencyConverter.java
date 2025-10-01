package converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Map<String, Double> RATES = new HashMap<>();

    static {
        RATES.put("USD", 1.0);
        RATES.put("EUR", 0.92);
        RATES.put("RUB", 95.5);
        RATES.put("GBP", 0.78);
        RATES.put("JPY", 150.0);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в конвертер валют!");
        System.out.println("Доступные валюты: USD, EUR, RUB, GBP, JPY");

        System.out.print("Введите сумму: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите число.");
            return;
        }

        System.out.print("Введите валюту (например USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        if (!RATES.containsKey(fromCurrency)) {
            System.out.println("Ошибка: неизвестная валюта.");
            return;
        }

        System.out.println("\nКонвертация:");
        for (String toCurrency : RATES.keySet()) {
            if (!toCurrency.equals(fromCurrency)) {
                double converted = convert(amount, fromCurrency, toCurrency);
                System.out.printf("%s: %.2f%n", toCurrency, converted);
            }
        }
    }

    private double convert(double amount, String from, String to) {
        double inUSD = amount / RATES.get(from);
        return inUSD * RATES.get(to);
    }
}
