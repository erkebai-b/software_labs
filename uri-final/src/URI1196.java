import java.util.Scanner;

public class URI1196 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyboard = "`1234567890-=QWERTYUIOP[]\\\\ASDFGHJKL;'ZXCVBNM,./";

        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            char letter;

            for (int i = 0; i < word.length(); i++) {
                letter = word.charAt(i);

                if (letter != ' ') {
                    char answer = keyboard.charAt(keyboard.indexOf(letter) - 1);
                    System.out.print(answer);
                }

                if (letter == ' ' || letter == '`') {
                    System.out.print(letter);
                }
            }

            System.out.println();
        }
    }
}
