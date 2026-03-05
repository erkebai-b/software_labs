import java.util.Scanner;
import java.util.StringTokenizer;

public class URI1218 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = 0;
        while (scanner.hasNextInt()) {
            int numOfShoes = scanner.nextInt();
            scanner.nextLine();

            if (cases != 0) {
                System.out.println();
            }

            int female = 0;
            int male = 0;

            String line = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line);

            while (tokenizer.hasMoreTokens()) {
                int size = Integer.parseInt(tokenizer.nextToken());
                char gender = tokenizer.nextToken().charAt(0);

                if (size == numOfShoes) {
                    if (gender == 'M') {
                        male++;
                    } else {
                        female++;
                    }
                }
            }
            cases++;

            System.out.printf("Caso %d:\nPares Iguais: %d\nF: %d\nM: %d\n", cases, male + female, female, male);
        }
    }
}