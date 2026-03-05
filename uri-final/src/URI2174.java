import java.util.Scanner;

public class URI2174 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        String[] pomekons = new String[cases];
        for (int i = 0; i < cases; i++) {
            pomekons[i] = scanner.next();
        }

        for (int k = 0; k < cases; k++) {
            for (int j = k + 1; j < cases; ) {
                if (pomekons[k].equals(pomekons[j])) {
                    if (cases - 1 - j >= 0) {
                        System.arraycopy(pomekons, j + 1,
                                pomekons, j, cases - 1 - j);
                    }
                    cases--;
                } else {
                    j++;
                }
            }
        }
        System.out.println("Falta(m) " + (151 - cases) + " pomekon(s).");
    }
}