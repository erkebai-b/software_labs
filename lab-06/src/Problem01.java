import java.util.Scanner;

class Rectangle {
    private final int x, y;
    private final int width, height;

    Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void present() {
        System.out.println(this);
    }

    boolean areCoordsInside(int x, int y) {
        return x >= this.x && x <= this.x + width &&
                y >= this.y && y <= this.y + height;
    }

    public String toString() {
        return String.format("Rect: %d, %d, %d, %d,", x, y, width, height);
    }
}

public class Problem01{
    public static void main(String[] args) {
        Rectangle[] rectangles = {
                new Rectangle(0,0,100,100),
                new Rectangle(200,0,50,60),
                new Rectangle(0,-200,100,30),
                new Rectangle(0,0,130,100),
                new Rectangle(400,400,1000,1000),
                new Rectangle(450,400,50,70),
                new Rectangle(480,480,500,1000),
                new Rectangle(490,500,700,900),
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

            for (var rectangle : rectangles) {
                if (rectangle.areCoordsInside(mouseX, mouseY)) {
                    rectangle.present();
                }
            }
        } while (true);
    }
}

