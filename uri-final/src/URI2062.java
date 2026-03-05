import java.util.Scanner;

public class URI2062 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int numOfWords = inp.nextInt();

        for (int i = 0; i < numOfWords; i++) {
            String str = inp.next();
            if (str.length() == 3) {
                if (str.startsWith("OB") || str.startsWith("UR") && !str.endsWith("I")) {
                    str = str.substring(0, 2) + "I";
                }
            }
            if (i != numOfWords - 1) {
                System.out.print(str + " ");
            } else {
                System.out.print(str);
            }
        }
        System.out.println();

    }
}
