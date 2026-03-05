import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Field field = new Field();

        Turtle turtle1 = new Turtle(field, 0, 0, 1, 0);
        Turtle turtle2 = new Turtle(field, 19, 19, -1, 0);
        Turtle[] turtles = new Turtle[]{turtle1, turtle2};
        Turtle selectedTurtle = turtles[0];

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                String input = scanner.nextLine();
                String[] parts = input.split("\\s+");
                if (!(parts.length > 0 && parts[0].trim().length() > 0)) {
                    throw new IllegalArgumentException("No commands to execute were provided.");
                }
                String command = parts[0].trim();
                switch (command) {
                    case "select" -> {
                        if (parts.length > 2) {
                            throw new IllegalArgumentException("More arguments than necessary were provided for the \"select\" command.");
                        } else if (parts.length < 2) {
                            throw new IllegalArgumentException("The turtle number was not provided.");
                        }
                        int turtleIndex;
                        try {
                            turtleIndex = Integer.parseInt(parts[1]) - 1;
                        } catch (NumberFormatException e) {
                            throw new NumberFormatException("The turtle number is not valid.");
                        }
                        if (turtleIndex >= 0 && turtleIndex < turtles.length) {
                            selectedTurtle = turtles[turtleIndex];
                        } else {
                            throw new NumberFormatException("There is no turtle with the number " + "\"" + parts[1] + "\"" + ".");
                        }
                    }
                    case "pen-up" -> selectedTurtle.putPenUp();
                    case "pen-down" -> selectedTurtle.putPenDown();
                    case "turn-right" -> selectedTurtle.turnRight();
                    case "turn-left" -> selectedTurtle.turnLeft();
                    case "move" -> {
                        if (parts.length > 2) {
                            throw new IllegalArgumentException("More arguments than necessary were provided for the \"move\" command.");
                        } else if (parts.length < 2) {
                            throw new IllegalArgumentException("The number of steps was not provided.");
                        }
                        int steps;
                        try {
                            steps = Integer.parseInt(parts[1]);
                        } catch (NumberFormatException e) {
                            throw new NumberFormatException("The number of steps is not valid.");
                        }
                        if (steps < 0) {
                            throw new IllegalArgumentException("The number of steps can't be negative.");
                        }
                        selectedTurtle.move(steps);
                    }
                    case "display" -> field.display(turtles);
                    case "exit" -> System.exit(0);
                    default -> throw new IllegalArgumentException("Unknown command.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage() + " Please, try again.");
            }
        }
    }
}
