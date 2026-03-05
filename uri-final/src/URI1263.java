import java.util.Scanner;

public class URI1263 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toLowerCase();

            int result = 0;
            int strLength = 0;
            char beginning = 0;

            for (int i = 0; i < line.length(); i++) {
                char current = line.charAt(i);
                if (current != ' ' && (i == 0 || line.charAt(i - 1) == ' ')) {
                    if (beginning == 0) {
                        beginning = current;
                        strLength++;
                    } else if (beginning == current) {
                        strLength++;
                    } else {
                        if (strLength >= 2) {
                            result++;
                        }

                        strLength = 1;
                        beginning = current;
                    }
                }
            }
            if (strLength >= 2) {
                result++;
            }
            System.out.println(result);

        }
    }
}