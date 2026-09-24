import java.util.Locale;
import java.util.Scanner;

/** Exercise 2.2.6: solve a linear equation, a 2x2 linear system, and a quadratic equation. */
public class EquationSolver {
    private static final double EPSILON = 1e-10;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an equation type:");
        System.out.println("1 - First-degree equation ax + b = 0");
        System.out.println("2 - 2x2 first-degree system");
        System.out.println("3 - Second-degree equation ax^2 + bx + c = 0");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveLinearEquation(scanner);
                break;
            case 2:
                solveLinearSystem(scanner);
                break;
            case 3:
                solveQuadraticEquation(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void solveLinearEquation(Scanner scanner) {
        System.out.print("Enter a and b: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        if (isZero(a)) {
            if (isZero(b)) {
                System.out.println("Infinitely many solutions.");
            } else {
                System.out.println("No solution.");
            }
        } else {
            System.out.printf("x = %.6f%n", -b / a);
        }
    }

    private static void solveLinearSystem(Scanner scanner) {
        System.out.println("Enter a1 b1 c1 for a1*x + b1*y = c1:");
        double a1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double c1 = scanner.nextDouble();
        System.out.println("Enter a2 b2 c2 for a2*x + b2*y = c2:");
        double a2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();
        double c2 = scanner.nextDouble();

        double determinant = a1 * b2 - a2 * b1;
        double determinantX = c1 * b2 - c2 * b1;
        double determinantY = a1 * c2 - a2 * c1;
        if (!isZero(determinant)) {
            System.out.printf("x = %.6f, y = %.6f%n", determinantX / determinant, determinantY / determinant);
        } else if (isZero(determinantX) && isZero(determinantY)) {
            System.out.println("Infinitely many solutions.");
        } else {
            System.out.println("No solution.");
        }
    }

    private static void solveQuadraticEquation(Scanner scanner) {
        System.out.print("Enter a, b, and c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        if (isZero(a)) {
            if (isZero(b)) {
                System.out.println(isZero(c) ? "Infinitely many solutions." : "No solution.");
            } else {
                System.out.printf("This is linear: x = %.6f%n", -c / b);
            }
            return;
        }

        double discriminant = b * b - 4 * a * c;
        if (discriminant > EPSILON) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("x1 = %.6f, x2 = %.6f%n", root1, root2);
        } else if (isZero(discriminant)) {
            System.out.printf("Double root: x = %.6f%n", -b / (2 * a));
        } else {
            System.out.println("No real root.");
        }
    }

    private static boolean isZero(double value) {
        return Math.abs(value) < EPSILON;
    }
}
