import java.util.Locale;
import java.util.Scanner;

/** Exercise 6.4: accept a month name, abbreviation, or number and validate its year. */
public class DaysOfMonth {
    private static final String[] MONTHS = {
            "january", "february", "march", "april", "may", "june",
            "july", "august", "september", "october", "november", "december"
    };
    private static final int[] COMMON_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        int month;
        int year;

        while (true) {
            System.out.print("Enter month (name, abbreviation, or number): ");
            String input = scanner.nextLine().trim().toLowerCase(Locale.US);
            month = parseMonth(input);
            if (month == -1) {
                System.out.println("Invalid month. Please try again.");
                continue;
            }

            System.out.print("Enter a non-negative year: ");
            String yearInput = scanner.nextLine().trim();
            try {
                year = Integer.parseInt(yearInput);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid year. Please try again.");
                continue;
            }
            if (year < 0) {
                System.out.println("Year must be non-negative. Please try again.");
                continue;
            }
            break;
        }

        int days = COMMON_DAYS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            days++;
        }
        System.out.printf("%s %d has %d days.%n", MONTHS[month - 1], year, days);
    }

    private static int parseMonth(String input) {
        try {
            int number = Integer.parseInt(input);
            return number >= 1 && number <= 12 ? number : -1;
        } catch (NumberFormatException ignored) {
            // Continue with textual forms.
        }
        String normalized = input.endsWith(".") ? input.substring(0, input.length() - 1) : input;
        for (int i = 0; i < MONTHS.length; i++) {
            String month = MONTHS[i];
            if (normalized.equals(month) || normalized.equals(month.substring(0, 3))) {
                return i + 1;
            }
        }
        return -1;
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
