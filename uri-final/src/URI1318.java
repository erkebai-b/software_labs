import java.util.Scanner;

public class URI1318 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int numOfPeople = scanner.nextInt();
            int cases = scanner.nextInt();

            if (numOfPeople == 0 && cases == 0) {
                break;
            }

            int[] tickets = new int[numOfPeople];

            int counter = 0;
            for (int i = 0; i < cases; i++) {
                int numOfTickets = scanner.nextInt();
                tickets[numOfTickets - 1]++;
            }

            for (int i = 0; i < numOfPeople; i++) {
                if (tickets[i] > 1)
                    counter++;
            }

            System.out.println(counter);
        }
    }
}
