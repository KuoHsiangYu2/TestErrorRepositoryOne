
import java.nio.charset.Charset;
import java.util.Scanner;

public class Exam {

    // 印空格.
    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    // 印星星.
    private static void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
    }

    private static void printStar(int width) {
        if (width < 1) {
            System.out.println("Width must be greater than 1");
            return;
        }
        if ((width % 2) == 0) {
            System.out.println("Width must be an odd number.");
            return;
        }

        int mid = (width / 2);

        // 印出沙漏上半身 + 中間點.
        for (int i = 0; i <= mid; i++) {
            printSpaces(i);
            printStars(width - (2 * i));
            System.out.println();
        }

        // 印出沙漏下半身.
        for (int i = (mid - 1); i >= 0; i--) {
            printSpaces(i);
            printStars(width - (2 * i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Eclipse IDE, UTF-8 setting.
        Scanner scanner = new Scanner(System.in, Charset.forName("UTF-8").name());

        System.out.print("Please enter width: ");
        int width = scanner.nextInt();

        // 印出沙漏.
        printStar(width);

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

}
