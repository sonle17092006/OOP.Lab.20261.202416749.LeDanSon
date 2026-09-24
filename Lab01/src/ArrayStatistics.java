import java.util.Arrays;
import java.util.Scanner;

/** Exercise 6.5: sort an array and calculate its sum and average. */
public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int length = scanner.nextInt();
        if (length <= 0) {
            System.out.println("Array length must be positive.");
            return;
        }

        double[] values = new double[length];
        for (int i = 0; i < values.length; i++) {
            System.out.printf("Enter element %d: ", i + 1);
            values[i] = scanner.nextDouble();
        }
        Arrays.sort(values);
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        System.out.println("Sorted array: " + Arrays.toString(values));
        System.out.printf("Sum: %.6f%n", sum);
        System.out.printf("Average: %.6f%n", sum / values.length);
    }
}
