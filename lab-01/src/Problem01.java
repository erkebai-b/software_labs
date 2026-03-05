import java.util.Scanner;

public class Problem01 {
    static int turtleX, turtleY;
    static int turtleDX, turtleDY;
    static boolean turtleIsPenDown;

    //Turtle
    //Services/Behaviour

    public static void turtleConstruct() {

        turtleX = 0;
        turtleY = 0;

        turtleDX = 1;
        turtleDY = 0;

        turtleIsPenDown = false;
    }

    public static void turtlePutPenUp() {

        turtleIsPenDown = false;
    }

    public static void turtlePutPenDown() {

        turtleIsPenDown = true;
    }

    public static void turtleTurnRight() {

        int temp = turtleDX;

        turtleDX = -turtleDY;

        turtleDY = temp;
    }

    public static void turtleTurnLeft() {

        int temp = turtleDX;

        turtleDX = turtleDY;

        turtleDY = -temp;
    }

    public static void turtleMove(int steps) {

        for (int i = 0; i < steps; i++) {
            int nextX = turtleX + turtleDX;
            int nextY = turtleY + turtleDY;
            if (!fieldAreCordsInside(nextX, nextY)) {
                break;
            }
            if (turtleIsPenDown) {
                fieldMark(turtleX, turtleY);
            }
            turtleX = nextX;
            turtleY = nextY;
        }
    }

    //Field
    //State Data
    static final int FIELD_WIDTH = 20;
    static final int FIELD_HEIGHT = 20;
    static char[][] field;
    static final char EMPTY_CELL = '.';
    static final char TURTLE_CELL = 'T';
    static final char MARKED_CELL = '*';

    public static void fieldConstruct() {
        field = new char[FIELD_HEIGHT][FIELD_WIDTH];
        for (int y = 0; y < FIELD_HEIGHT; y++) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                field[y][x] = EMPTY_CELL;
            }
        }
    }

    public static void fieldDisplay() {
        for (int y = 0; y < FIELD_HEIGHT; y++) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                if (x == turtleX && y == turtleY) {
                    System.out.print(TURTLE_CELL);
                } else {
                    System.out.print(field[x][y]);
                }
            }
            System.out.println();
        }
    }

    public static boolean fieldAreCordsInside(int x, int y) {
        return x >= 0 && x < FIELD_WIDTH && y >= 0 && y < FIELD_HEIGHT;
    }

    public static void fieldMark(int x, int y) {
        if (fieldAreCordsInside(x, y)) {
            field[x][y] = MARKED_CELL;
        }
    }

    // public static void main (String[] args){
    public static void main(String[] args) {
        turtleConstruct();
        fieldConstruct();
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
                    case "pen-up" -> turtlePutPenUp();
                    case "pen-down" -> turtlePutPenDown();
                    case "turn-right" -> turtleTurnRight();
                    case "turn-left" -> turtleTurnLeft();
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
                        turtleMove(steps);
                    }
                    case "display" -> fieldDisplay();
                    case "exit" -> System.exit(0);
                    default -> throw new IllegalArgumentException("Unknown command.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage() + " Please, try again.");
            }
        }
    }
}