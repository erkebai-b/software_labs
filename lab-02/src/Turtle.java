public class Turtle {
    int x, y;
    int dx, dy;
    boolean penDown;
    Field field;

    Turtle(Field field, int x1, int y1, int dx1, int dy1) {
        x = x1;
        y = y1;
        dx = dx1;
        dy = dy1;
        penDown = false;
        this.field = field;
    }

    void putPenUp() {
        penDown = false;
    }

    void putPenDown() {
        penDown = true;
    }

    void turnRight() {
        int temp = dx;
        dx = -dy;
        dy = temp;
    }

    void turnLeft() {
        int temp = dx;
        dx = dy;
        dy = -temp;
    }

    void move(int steps) {
        for (int i = 0; i < steps; i++) {
            int nextX = x + dx;
            int nextY = y + dy;
            if (!field.areCordsInside(nextX, nextY)) {
                break;
            }
            if (penDown) {
                field.mark(x, y);
            }
            x = nextX;
            y = nextY;
        }
    }
}
