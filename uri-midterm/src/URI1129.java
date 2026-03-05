import java.util.Scanner;


public class URI1129 {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        int n,a,b,c,d,e;
        String correta =  "";
        do {
            n = scanner.nextInt();
            for(int i=0;i<n;i++){
                int total =0;
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                d = scanner.nextInt();
                e = scanner.nextInt();

                if(a <= 127){
                    correta = "A";
                    total++;
                }

                if(b <= 127){
                    correta = "B";
                    total++;
                }

                if(c <= 127){
                    correta = "C";
                    total++;
                }

                if(d <= 127){
                    correta = "D";
                    total++;
                }

                if(e <= 127){
                    correta = "E";
                    total++;
                }

                if(total ==1){
                    System.out.println(correta);
                }else{
                    System.out.println("*");
                }
            }

        }while(n != 0);
    }

}