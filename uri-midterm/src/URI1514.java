import java.util.*;

public class URI1514 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        int integers = scanner.nextInt();

        while (lines != 0 && integers != 0){
            int[] solvedByEveryone = new int[integers];
            boolean someoneSolved = false;
            boolean allProblemsSolved = true;
            boolean everybodySolved = false;
            boolean solvedAtLeastOne = true;

            for (int i = 0; i < lines; i++) {
                int solvedProblems = 0;
                for (int j = 0; j < integers; j++){
                    int num = scanner.nextInt();
                    if (num == 1) {
                        solvedProblems++;
                        solvedByEveryone[j]++;
                    }
                }

                if (solvedProblems == integers) someoneSolved    = true;
                if (solvedProblems == 0)        solvedAtLeastOne = false;
            }

            for (int j = 0; j < integers; j++) {
                if (solvedByEveryone[j] == 0)     allProblemsSolved  = false;
                if (solvedByEveryone[j] == lines) everybodySolved = true;
            }

            int result = 0;
            if (!someoneSolved)   ++result;
            if(allProblemsSolved)           ++result;
            if(!everybodySolved)        ++result;
            if(solvedAtLeastOne) ++result;

            System.out.println(result);

            lines = scanner.nextInt();
            integers = scanner.nextInt();
        }
    }
}