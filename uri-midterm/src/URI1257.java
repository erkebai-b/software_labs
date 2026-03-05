import java.util.*;

public class URI1257 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int cases = inp.nextInt();

        for (int i = 0; i < cases; i++) {
            int testCase = inp.nextInt();
            int count = 0;
            String[] str = new String[testCase];

            for (int j = 0; j < testCase; j++) {
                str[j] = inp.next();
                for (int k = 0; k < str[j].length(); k++) {
                    count += j + k + ((int)str[j].charAt(k) - 'A');

                }
            }

            System.out.println(count);
        }
    }
}