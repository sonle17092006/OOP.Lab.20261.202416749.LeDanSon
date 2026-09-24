import java.util.Scanner;

/** Exercise 6.6: add two matrices of the same size. */
public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();
        if (rows <= 0 || columns <= 0) {
            System.out.println("Matrix dimensions must be positive.");
            return;
        }

        int[][] first = readMatrix(scanner, rows, columns, "first");
        int[][] second = readMatrix(scanner, rows, columns, "second");
        int[][] sum = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                sum[row][column] = first[row][column] + second[row][column];
            }
        }

        System.out.println("Sum matrix:");
        printMatrix(sum);
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int columns, String label) {
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the " + label + " matrix:");
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%d ", value);
            }
            System.out.println();
        }
    }
}
