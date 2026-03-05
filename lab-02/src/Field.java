public class Field {
    static final int WIDTH = 20;
    static final int HEIGHT = 20;
    static final char EMPTY_CELL = '.';
    static final char TURTLE_CELL = 'T';
    static final char MARKED_CELL = '*';

    char[][] map;

    Field() {
        map = new char[HEIGHT][WIDTH];
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                map[y][x] = EMPTY_CELL;
            }
        }
    }

    void display(Turtle[] turtles) {
        for (int y = 0; y < HEIGHT; y++) {
            rowLoop:
            for (int x = 0; x < WIDTH; x++) {
                for (Turtle turtle : turtles) {
                    if (x == turtle.x && y == turtle.y) {
                        System.out.print(TURTLE_CELL);
                        continue rowLoop;
                    }
                }
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
    }

    boolean areCordsInside(int x, int y) {
        return x >= 0 && x < WIDTH &&
                y >= 0 && y < HEIGHT;
    }

    void mark(int x, int y) {
        if (areCordsInside(x, y)) {
            map[y][x] = MARKED_CELL;
        }
    }
}
