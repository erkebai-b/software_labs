import java.util.Scanner;

public class URI1248 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        scanner.nextLine();
        for (int c = 0; c < cases; c++) {
            String dieta = scanner.nextLine();
            String breakfast = scanner.nextLine();
            String lunch = scanner.nextLine();

            int[] diet = new int[26];
            for (int i = 0; i < dieta.length(); i++) {
                char ch = dieta.charAt(i);
                diet[ch - 'A']++;
            }

            for (int i = 0; i < breakfast.length(); i++) {
                char ch = breakfast.charAt(i);
                diet[ch - 'A']--;
            }

            for (int i = 0; i < lunch.length(); i++) {
                char letter = lunch.charAt(i);
                diet[letter - 'A']--;
            }

            boolean isCheating = false;
            for (int e : diet) {
                if (e < 0) {
                    isCheating = true;
                    break;
                }
            }

            if (isCheating) {
                System.out.println("CHEATER");
            } else {
                for (int i = 0; i < diet.length; i++) {
                    if (diet[i] > 0) {
                        System.out.print((char) (i + 'A'));
                    }
                }

                System.out.println();
            }
        }
    }
}
