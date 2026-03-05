import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class URI1609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int numOfSheep = scanner.nextInt();
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < numOfSheep; j++) {
                int sequenceOfSheep = scanner.nextInt();
                set.add(sequenceOfSheep);
            }

            System.out.println(set.size());
        }
    }
}
