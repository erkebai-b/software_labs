import java.util.Locale;
import java.util.Scanner;

    public class URI1332 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            sc.useLocale(Locale.ENGLISH);
            Locale.setDefault(new Locale("en", "US"));

            int n = Integer.parseInt(sc.nextLine());
            for (int i=0; i<n; i++){
                String enter = sc.nextLine();
                switch (enter) {
                    case "one" -> System.out.println("1");
                    case "two" -> System.out.println("2");
                    case "Three" -> System.out.println("3");
                    default -> {
                        char[] x = enter.toCharArray();
                        if (x[0] == 'o' && x[1] == 'n') System.out.println("1");
                        else if (x[0] == 'o' && x[2] == 'e') System.out.println("1");
                        else if (x[1] == 'n' && x[2] == 'e') System.out.println("1");
                        else if (x[0] == 't' && x[1] == 'w') System.out.println("2");
                        else if (x[0] == 't' && x[2] == 'o') System.out.println("2");
                        else if (x[1] == 'w' && x[2] == 'o') System.out.println("2");
                        else if (x[0] == 't' && x[1] == 'h' && x[2] == 'r' && x[3] == 'e') System.out.println("3");
                        else if (x[0] == 't' && x[1] == 'h' && x[2] == 'r' && x[4] == 'e') System.out.println("3");
                        else if (x[0] == 't' && x[1] == 'h' && x[3] == 'e' && x[4] == 'e') System.out.println("3");
                        else if (x[0] == 't' && x[2] == 'r' && x[3] == 'e' && x[4] == 'e') System.out.println("3");
                        else if (x[1] == 'h' && x[2] == 'r' && x[3] == 'e' && x[4] == 'e') System.out.println("3");
                    }
                }
            }
            sc.close();
        }
    }

