import java.util.Scanner;

public class URI1300 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MOVE = 360 / 60;

        while (scanner.hasNextLine()) {
            int angle = scanner.nextInt();
            if (angle % MOVE == 0) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }
}
