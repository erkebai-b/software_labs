import java.util.Scanner;

public class URI1239 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNextLine()) {
            String str = inp.nextLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '_' || str.charAt(i) == '*') {
                    str = str.replaceFirst("\\*", "<b>").replaceFirst("\\*",
                            "</b>").replaceFirst("_", "<i>").replaceFirst("_", "</i>");
                }
            }
            System.out.println(str);

        }
    }
}