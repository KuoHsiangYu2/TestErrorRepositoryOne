import static java.lang.System.out;

public class MultiplicationTable {
    public static void main(String[] args) {
        /* 傳統雙層for迴圈 */
        for (int i = 1; i <= 9; ++i) {
            for (int j = 1; j <= 9; ++j) {
                out.printf("%d×%d=%02d ", j, i, (j * i));
            }
            out.println();
        }
    }
}
