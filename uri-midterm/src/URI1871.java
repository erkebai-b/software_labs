import java.util.*;

public class URI1871 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while (inp.hasNextLine()) {
            int num1 = inp.nextInt();
            int num2 = inp.nextInt();

            if (num1 == 0 && num2 == 0) {
                break;
                //System.out.println("");
            }

            String str = Integer.toString(num1 + num2);
            str = str.replace("0", "");
            System.out.println(str);
        }
    }
}