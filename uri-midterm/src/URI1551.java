import java.util.Scanner;

public class URI1551 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int cases = Integer.parseInt(inp.nextLine());

        for (int i = 0; i < cases; i++) {
            String stringMsg = inp.nextLine();
            boolean[] letters = new boolean[26];

            for (char charText : stringMsg.toCharArray()) {
                if (Character.isLetter(charText)) {
                    letters[charText - 'a'] = true;
                }
            }

            int difNumLetters = 0;
            for (boolean mistake : letters) {
                if (mistake) {
                    difNumLetters++;
                }
            }

            String msg;
            if (difNumLetters == 26) {
                msg = "frase completa";
            } else if (difNumLetters < 13) {
                msg = "frase mal elaborada";
            } else {
                msg = "frase quase completa";
            }

            System.out.println(msg);
        }
    }
}
