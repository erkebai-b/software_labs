import java.util.Arrays;
import java.util.Scanner;

public class URI2137 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int numOfBooks = scanner.nextInt();
            String[] books = new String[numOfBooks];

            for (int i = 0; i < numOfBooks; ++i) {
                books[i] = scanner.next();
            }


            Arrays.sort(books);

            for (String book : books) {
                System.out.println(book);
            }

        }
    }
}
