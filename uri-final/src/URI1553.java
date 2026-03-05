import java.util.Scanner;

public class URI1553 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int SIZE = 101;

        while (true) {
            int numOfQuestions = scanner.nextInt();
            int numOfFrequent = scanner.nextInt();

            if (numOfQuestions == 0 && numOfFrequent == 0) {
                break;
            }

            int[] frequency = new int[SIZE];
            int counter = 0;
            for (int i = 0; i < numOfQuestions; i++) {
                frequency[scanner.nextInt()]++;
            }

            for (int i = 0; i < SIZE; i++) {
                if (frequency[i] >= numOfFrequent) {
                    counter++;
                }
            }

            System.out.println(counter);
        }
    }
}
