import java.util.Scanner;

public class URI1272 {

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        int testcase = obj.nextInt();
        String s = obj.nextLine();

        for (int o = 0; o < testcase; o++) {
            s = obj.nextLine();
            int k = 0;
            while (k < s.length()) {

                while (k < s.length() && s.charAt(k) == ' ') {
                    k++;
                }
                if (k < s.length())
                    System.out.print(s.charAt(k));

                while (k < s.length() && s.charAt(k) != ' ') {
                    k++;
                }
            }
            System.out.print("\n");
        }
    }
}