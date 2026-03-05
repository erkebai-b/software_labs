import java.util.Scanner;

public class URI2651 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        String link = "zelda";

        while (scanner.hasNext()) {
            str = scanner.next().toLowerCase();
            if (str.contains(link)) {
                System.out.println("Link Bolado");
            } else {
                System.out.println("Link Tranquilo");
            }
        }
    }
}
