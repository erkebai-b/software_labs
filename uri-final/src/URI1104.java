import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class URI1104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int cardsOfAlice = scanner.nextInt();
            int cardsOfBetty = scanner.nextInt();

            if (cardsOfAlice == 0 && cardsOfBetty == 0) {
                break;
            }

            int counter;
            Set<Integer> m1 = new HashSet<>();
            Set<Integer> m2 = new HashSet<>();

            for (int i = 0; i < cardsOfAlice; i++) {
                int x = scanner.nextInt();
                m1.add(x);
            }

            for (int i = 0; i < cardsOfBetty; i++) {
                int x = scanner.nextInt();
                m2.add(x);
            }

            int mistake = m1.size() + m2.size();
            counter = Math.min(m1.size(), m2.size());

            m1.addAll(m2);
            mistake -= m1.size();

            System.out.println(counter - mistake);
        }
    }
}
