import java.util.Scanner;

public class URI1873 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int cases = inp.nextInt();

        String msg;
        for (int i = 0; i < cases; i++) {
            String word1 = inp.next();
            String word2 = inp.next();

            if (word1.equals(word2)) {
                msg = "empate";
            } else if (word1.equals("tesoura") && word2.equals("papel")) {
                msg = "rajesh";
            } else if (word1.equals("papel") && word2.equals("pedra")) {
                msg = "rajesh";
            } else if (word1.equals("pedra") && word2.equals("lagarto")) {
                msg = "rajesh";
            } else if (word1.equals("lagarto") && word2.equals("spock")) {
                msg = "rajesh";
            } else if (word1.equals("spock") && word2.equals("tesoura")) {
                msg = "rajesh";
            } else if (word1.equals("lagarto") && word2.equals("papel")) {
                msg = "rajesh";
            } else if (word1.equals("tesoura") && word2.equals("lagarto")) {
                msg = "rajesh";
            } else if (word1.equals("papel") && word2.equals("spock")) {
                msg = "rajesh";
            } else if (word1.equals("spock") && word2.equals("pedra")) {
                msg = "rajesh";
            } else if (word1.equals("pedra") && word2.equals("tesoura")) {
                msg = "rajesh";
            } else {
                msg = "sheldon";
            }

            System.out.println(msg);
        }
    }
}