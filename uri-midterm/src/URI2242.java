import java.util.Scanner;

public class URI2242 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        StringBuilder word = new StringBuilder();

        for(int i = 0 ; i < line.length(); i++)
            if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i'
                    || line.charAt(i) == 'o' || line.charAt(i) == 'u') {
                word.append(line.charAt(i));
            }

        String reword = new StringBuilder(word.toString()).reverse().toString();

        if (word.toString().equals(reword))
            System.out.println("S");
        else
            System.out.println("N");
    }
}