import java.util.Scanner;

public class URI1305 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextDouble()) {
            double num = scanner.nextDouble();
            double cutOff = scanner.nextDouble();

            int numInInt = (int) num;
            num -= numInInt;

            if (num > cutOff) {
                numInInt++;
            }

            System.out.println(numInInt);
        }
    }
}
