import java.util.Scanner;

/** Exercise 6.3: print a centered-height-left triangle of stars. */
public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height: ");
        int height = scanner.nextInt();
        if (height < 0) {
            System.out.println("Height must be non-negative.");
            return;
        }
        for (int row = 1; row <= height; row++) {
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
