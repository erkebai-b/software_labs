import java.util.Scanner;

public class URI1168 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int led = 0;
        String s;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            s = scanner.next();
            for (int c = 0; c < s.length(); c++) {
                if (s.charAt(c) == '1')
                    led += 2;
                if (s.charAt(c) == '2' || s.charAt(c) == '3' || s.charAt(c) == '5')
                    led += 5;
                if (s.charAt(c) == '4')
                    led += 4;
                if (s.charAt(c) == '6' || s.charAt(c) == '9' || s.charAt(c) == '0')
                    led += 6;
                if (s.charAt(c) == '7')
                    led += 3;
                if (s.charAt(c) == '8')
                    led += 7;
            }
            System.out.println(led + " leds");
            led = 0;
        }
    }
}