import java.util.Scanner;

public class URI2157 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int cases = inp.nextInt();

        for (int i = 0; i < cases; i++) {
            int beginning = inp.nextInt();
            int ending = inp.nextInt();

            StringBuilder subString = new StringBuilder();
            for (int k = beginning; k <= ending; k++) {
                subString.append(k);
            }

            String result = subString.toString() + subString.reverse();
            System.out.println(result);
        }
    }
}
