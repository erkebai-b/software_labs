import java.util.Scanner;

class Shape {
    protected int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void present() {
        System.out.println(this);
    }


    void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    boolean areCoordsInside(int x, int y) {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Shape: %d, %d", x, y);
    }

}

class Rectangle extends Shape {
    private final int width, height;

    Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    boolean areCoordsInside(int x, int y) {
        return x >= this.x && x <= this.x + width &&
                y >= this.y && y <= this.y + height;
    }

    @Override
    public String toString() {
        return String.format("Rect: %d, %d, %d, %d", x, y, width, height);
    }
}

class Circle extends Shape {
    private final int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    boolean areCoordsInside(int x, int y) {
        int dx = x - this.x;
        int dy = y - this.y;
        return dx * dx + dy * dy <= radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle: %d, %d, %d", x, y, radius);
    }
}

class Cross extends Shape {
    private final Rectangle widthRect;
    private final Rectangle heightRect;


    public Cross(int x, int y, int x2, int y2) {
        super(x, y);
        heightRect = new Rectangle(x - x2 / 2, y - y2 / 2, x2, y2);
        widthRect = new Rectangle(x - y2 / 2, y - x2 / 2, y2, x2);
    }

    void move(int dx, int dy) {
        super.move(dx, dy);
        widthRect.move(dx, dy);
        heightRect.move(dx, dy);
    }

    @Override
    boolean areCoordsInside(int x, int y) {
        return heightRect.areCoordsInside(x, y) || widthRect.areCoordsInside(x, y);
    }

    public String toString() {
        return String.format("Cross: (%s), (%s)", heightRect, widthRect);
    }
}

public class Problem04 {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(10, 10, 100, 100),
                new Rectangle(400, 400, 100, 100),
                new Circle(500, 10, 100),
                new Circle(800, 800, 100),
                new Cross(190, 575, 10, 50)
        };

        var scanner = new Scanner(System.in);
        boolean shouldExit = false;
        do {
            System.out.print("cmd: ");
            var command = scanner.next();
            switch (command) {
                case "click":
                    System.out.print("x: ");
                    int mouseX = scanner.nextInt();
                    System.out.print("y: ");
                    int mouseY = scanner.nextInt();

                    for (var shape : shapes) {
                        if (shape.areCoordsInside(mouseX, mouseY)) {
                            shape.present();
                        }
                    }
                    break;
                case "present":
                    for (var shape : shapes) {
                        shape.present();
                    }
                    break;
                case "move":
                    System.out.print("x1: ");
                    int mouseX1 = scanner.nextInt();
                    System.out.print("y1: ");
                    int mouseY1 = scanner.nextInt();
                    System.out.print("x2: ");
                    int mouseX2 = scanner.nextInt();
                    System.out.print("y2: ");
                    int mouseY2 = scanner.nextInt();
                    for (int i = shapes.length - 1; i >= 0; i--) {
                        var shape = shapes[i];
                        if (shape.areCoordsInside(mouseX1, mouseY1)) {
                            shape.move(mouseX2 - mouseX1, mouseY2 - mouseY1);
                            break;
                        }
                    }
                    break;
                case "stop":
                    shouldExit = true;
                    break;
            }
        } while (!shouldExit);
    }
}
