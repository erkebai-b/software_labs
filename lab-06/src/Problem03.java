import java.util.Scanner;

class Shape {
    protected final int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void present() {
        System.out.println(this);
    }

    boolean areCoordsInside(int x, int y) {
        return false;
    }

    public String toString() {
        return String.format("Shape: %d, %d", x, y);
    }

}

class Circle extends Shape {

    private final int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    boolean areCoordsInside(int x, int y) {
        int dx = x - this.x;
        int dy = y - this.y;
        int distanceSquared = dx * dx - dy * dy;

        return distanceSquared <= radius * radius;
    }

    public String toString() {
        return String.format("Circle: %d, %d, %d", x, y, radius);
    }


    public static class Problem03 {

        public static void main(String[] args) {
            Shape[] shapes = {
                    new Rectangle(0, 0, 100, 100),
                    new Rectangle(200, 0, 50, 60),
                    new Rectangle(0, -200, 100, 30),
                    new Rectangle(0, 0, 130, 100),
                    new Circle(0, 0, 50),
                    new Circle(200, 0, 50),
            };

            var scanner = new Scanner(System.in);
            int mouseX, mouseY;
            do {
                System.out.print("x: ");
                mouseX = scanner.nextInt();
                System.out.print("y: ");
                mouseY = scanner.nextInt();
                if (mouseX == -1 && mouseY == -1) {
                    break;
                }

                for (var shape : shapes) {
                    if (shape.areCoordsInside(mouseX, mouseY)) {
                        shape.present();
                    }
                }
            } while (true);
        }
    }
}

class Rectangle extends Shape {
    private final int width, height;

    Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    boolean areCoordsInside(int x, int y) {
        return x >= this.x && x <= this.x + width &&
                y >= this.y && y <= this.y + height;
    }

    public String toString() {
        return String.format("Rect: %d, %d, %d, %d,", x, y, width, height);
    }
}
