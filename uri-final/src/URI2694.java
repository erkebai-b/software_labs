import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URI2694 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < inputs; ++i) {
            String input = scanner.nextLine();
            var allMatches = new ArrayList<String>();
            Matcher m = Pattern.compile("\\d+").matcher(input);
            while (m.find()) {
                allMatches.add(m.group());
            }
            long res = 0;
            for (String match : allMatches) {
                res += Integer.parseInt(match);
            }
            System.out.println(res);
        }
    }
}
