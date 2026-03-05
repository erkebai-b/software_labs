import java.io.IOException;
import java.util.Scanner;

public class URI1241 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String A = scanner.next();
            String B = scanner.next();
            if (A.endsWith(B))
                System.out.println("encaixa");
            else
                System.out.println("nao encaixa");
        }
    }

}