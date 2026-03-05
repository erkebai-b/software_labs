import java.util.Objects;
import java.util.Scanner;

public class URI1574 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int instructions = scanner.nextInt();

            int pointOfRobot = 0;
            String[] commands = new String[instructions];
            for (int j = 0; j < instructions; j++) {
                String command = scanner.next();

                if (Objects.equals(command, "LEFT")) {
                    pointOfRobot--;
                    commands[j] = "LEFT";
                } else if (Objects.equals(command, "RIGHT")) {
                    pointOfRobot++;
                    commands[j] = "RIGHT";
                } else if (Objects.equals(command, "SAME")) {
                    String unnecessaryWord = scanner.next();
                    if (Objects.equals(unnecessaryWord, "AS")) {
                        int num = scanner.nextInt();
                        if (commands[num - 1].equals("RIGHT")) {
                            pointOfRobot++;
                            commands[j] = "RIGHT";
                        } else {
                            pointOfRobot--;
                            commands[j] = "LEFT";
                        }
                    }
                }
            }

            System.out.println(pointOfRobot);
        }
    }
}
