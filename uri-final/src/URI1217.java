import java.util.Scanner;

public class URI1217 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        double average = 0;
        double sum = 0;

        for (int i = 1; i <= cases; i++) {
            int kg = 1;
            double expense = scanner.nextDouble();
            scanner.nextLine();
            average += expense;
            String fruit = scanner.nextLine().trim();

            for (int j = 0; j < fruit.length(); j++) {
                if (fruit.charAt(j) == ' ') {
                    kg++;
                }
            }

            sum += kg;
            System.out.printf("day %d: %d kg%n", i, kg);
        }

        System.out.printf("%.2f kg by day%n", sum / cases);
        System.out.printf("R$ %.2f by day%n", average / cases);
    }
}