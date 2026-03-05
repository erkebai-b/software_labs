import java.util.Scanner;

public class URI1558 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int value = (int) Math.ceil(Math.sqrt(num));
            boolean canBeRepresented = false;
            for (int i = 0; i <= value; i++) {
                for (int j = 0; j <= value; j++) {
                    if (i * i + j * j == num) {
                        canBeRepresented = true;
                        break;
                    }
                }
            }

            if (canBeRepresented) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
