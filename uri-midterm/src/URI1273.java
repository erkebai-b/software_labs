import java.util.Scanner;

public class URI1273 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int cases = inp.nextInt();
        boolean nextLine = false;

        while (cases != 0) {
            if (nextLine) {
                System.out.println();
            }
            String[] string = new String[cases];

            for (int i = 0; i < cases; i++) {
                string[i] = inp.next();
            }

            int max = 0;
            for (int n = 0; n < cases; n++) {
                if (string[n].length() > max) {
                    max = string[n].length();
                }
            }

            for (int k = 0; k < cases; k++) {
                System.out.printf("%" + max + "s%n", string[k]);
            }

            cases = inp.nextInt();
            nextLine = true;
        }
    }
}
