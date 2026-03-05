import java.util.Locale;
import java.util.Scanner;

public class URI1238 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        Locale.setDefault(new Locale("en", "US"));

        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String[] word = sc.nextLine().split(" ");
            char[] fr1 = word[0].toCharArray();
            char[] fr2 = word[1].toCharArray();
            String input = "";

            for (int z = 0; z < (fr1.length + fr2.length); z++) {
                if (z < fr1.length)
                    input += fr1[z];
                if (z < fr2.length)
                    input += fr2[z];
            }
            System.out.println(input);
        }
        sc.close();
    }
}