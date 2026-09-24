import java.util.Locale;
import java.util.Scanner;

/** Exercise 2.2.5: calculate the four basic operations on two doubles. */
public class BasicOperations {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first double: ");
        double first = scanner.nextDouble();
        System.out.print("Enter the second double: ");
        double second = scanner.nextDouble();

        System.out.printf("Sum: %.6f%n", first + second);
        System.out.printf("Difference: %.6f%n", first - second);
        System.out.printf("Product: %.6f%n", first * second);
        if (Double.compare(second, 0.0) == 0) {
            System.out.println("Quotient: undefined (division by zero)");
        } else {
            System.out.printf("Quotient: %.6f%n", first / second);
        }
    }
}
