import java.util.Scanner;

public class URI1768 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int nStars;
        while (inp.hasNext()) {
            nStars = inp.nextInt();

            int space = nStars / 2;
            for (int i = 0; i < (nStars + 1) / 2; i++) {
                for (int j = 0; j < nStars - space; j++) {
                    if (j < space) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }

                space--;
                System.out.println();
            }

            space = nStars / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < nStars - space; j++) {
                    if (j < space) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }

                space--;
                System.out.println();
            }

            System.out.println();
        }
    }
}