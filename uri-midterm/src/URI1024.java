import java.util.Scanner;

public class URI1024 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        for (int i = 0; i < input; i++) {

            StringBuilder word = new StringBuilder(readLine(scanner));

            for (int j = 0; j < word.length(); j++) {
                int code = word.charAt(j);
                if ((code >= 65 && code <= 90) || (code >= 97 && code <= 122)) {
                    char c = (char) (code + 3);
                    word.setCharAt(j, c);
                }
            }

            word.reverse();

            for (int j = word.length() / 2; j < word.length(); j++) {
                char c = (char) (word.charAt(j) - 1);
                word.setCharAt(j, c);
            }

            System.out.println(word.toString());
        }
    }
    public static String readLine(Scanner scanner) {
        String line = scanner.nextLine();
        while (line.isEmpty())
            line = scanner.nextLine();
        return line;
    }
}