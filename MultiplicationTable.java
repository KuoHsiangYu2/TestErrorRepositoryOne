import static java.lang.System.out;

public class MultiplicationTable {
    public static void main(String[] args) {
        /* 單層for迴圈 */
        for (int c = 1; c <= 81; ++c) {
            int i = ((c - 1) / 9) + 1;
            int j = ((c - 1) % 9) + 1;
            out.printf("%d×%d=%02d ", j, i, (j * i));
            if (j == 9) {
                out.println();
            }
        }
    }
}
