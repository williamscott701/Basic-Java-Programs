
import java.util.Scanner;

class Pattern {

    public static void main(String arg[]) {
        int i;

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        for (i = 0; i <= a; i++) {
            int t = i % 2;
            int r = i;
            if (t == 0) {
                while (r > 0) {
                    if (r % 2 == 0) {
                        System.out.print("  0");
                    } else if (r % 2 == 1) {
                        System.out.print("  1");
                    }
                    r--;
                }
            } else if (t == 1) {
                while (r > 0) {
                    if (r % 2 == 0) {
                        System.out.print("  0");
                    } else if (r % 2 == 1) {
                        System.out.print("  1");
                    }
                    r--;
                }
            }
            System.out.print("\n");
        }

    }

}
