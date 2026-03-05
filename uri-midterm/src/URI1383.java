
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class URI1383 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(in.readLine());
        int instance = 0;
        while (++instance <= t) {
            boolean flag = true;
            int n = 9;

            int[][] sudoku = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] p = in.readLine().split("\\s");
                int[] row = new int[n];
                for (int j = 0; j < n; j++) {
                    row[j] = Integer.parseInt(p[j]);
                }
                sudoku[i] = row;
            }

            // Files
            for (int i = 0; i < n; i++) {
                int[] aux = new int[n];
                for (int j = 0; j < n; j++) {
                    if (aux[sudoku[i][j] - 1] == 0) {
                        aux[sudoku[i][j] - 1]++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            // Columns

            for (int i = 0; i < n; i++) {
                int[] aux = new int[n];
                for (int j = 0; j < n; j++) {
                    if (aux[sudoku[j][i] - 1] == 0) {
                        aux[sudoku[j][i] - 1]++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            int root = 3;
            for (int i = 0; i < n; i += root) {
                for (int j = 0; j < n; j += root) {
                    int[] aux = new int[n];
                    for (int k = i; k < i + root; k++) {
                        for (int l = j; l < j + root; l++) {
                            if (aux[sudoku[k][l] - 1] == 0) {
                                aux[sudoku[k][l] - 1]++;
                            } else {
                                flag = false;
                                i = n;
                                j = n;
                                k = i + root;
                                l = j + root;
                            }
                        }
                    }
                }
            }
            out.println("Instance " + instance);
            out.println(flag ? "SIM\n" : "NAO\n");
        }
        out.close();
    }
}