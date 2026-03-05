import java.util.Scanner;

public class URI1255 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine();

        for (int k = 0; k < cases; k++) {
            String str = scanner.nextLine();
            int[] err = new int[26];
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLetter( str.charAt(i))) {
                    int idx = (int) Character.toLowerCase(str.charAt(i)) - 97;
                    err[idx]++;
                }
            }

            int max = 0;
            for (int i = 0; i < 26; i++) {
                if(max < err[i]){
                    max = err[i];
                }
            }

            for (int i = 0; i < 26; i++) {
                if(err[i] == max){
                    System.out.print((char)(i + 97));
                }

            }

            System.out.println();
        }
    }
}