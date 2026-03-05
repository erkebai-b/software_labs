import java.util.Scanner;

public class URI1607 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int cases = inp.nextInt();

        for (int i =0; i < cases; ++i) {
            String str1 = inp.next();
            String str2 = inp.next();

            int count = 0;
            for (int j = 0; j < str1.length(); j++) {
                int num = str2.charAt(j) - str1.charAt(j);
                if (str1.charAt(j) <= str2.charAt(j)) {
                    count += num;
                } else {
                    count += 26 + num;
                }
            }

            System.out.println(count);
        }
    }
}