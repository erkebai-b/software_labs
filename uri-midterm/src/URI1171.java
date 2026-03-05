import java.io.IOException;
import java.util.Scanner;
public class URI1171 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = 0, num = 0, cont = 0, aux = 0, cont2 = 0;
            n = sc.nextInt();
            int[] vet = new int[n];
            for (int i = 0; i < n; i++) {
                vet[i] = sc.nextInt();
            }
            for (int i = 0; i < vet.length; i++)
                for (int j = 0; j < vet.length - 1; j++) {
                    if (vet[j] > vet[j + 1]) {
                        aux = vet[j];
                        vet[j] = vet[j + 1];
                        vet[j + 1] = aux;
                    }
                }
            for (int j : vet) {
                cont = 0;
                num = j;
                for (int k : vet) {
                    if (j == k && j != 0 && k != cont2) {
                        cont++;
                    }
                }
                cont2 = j;
                if (cont != 0) {
                    System.out.println(num + " aparece " + cont + " vez(es)");
                }
            }
        }

    }

}