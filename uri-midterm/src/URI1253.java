import java.util.Scanner;

public class URI1253 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcase = scanner.nextInt();
        String s = scanner.nextLine();
        int v = 0;
        for (int o = 0; o < testcase; o++) {
            s = scanner.nextLine();
            if (v != 0)
                s = scanner.nextLine();
            int n = scanner.nextInt();
            char[] a = new char[s.length()];

            for (int i = 0; i < s.length(); i++) {
                int z = ((int) s.charAt(i) - n);
                if (z < 65) {
                    z = z + 26;
                }
                a[i] = (char) z;
                System.out.print(a[i]);
            }
            System.out.print("\n");
            v++;
        }
    }
}