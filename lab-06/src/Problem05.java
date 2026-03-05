import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Problem05 extends JFrame {
    private static final int MIN_RECT_SIZE = 50;
    private static final int MAX_RECT_SIZE = 100;

    private static final int MIN_CIRCLE_RADIUS = 25;
    private static final int MAX_CIRCLE_RADIUS = 50;

    private static final int MIN_CROSS_SIZE = 50;
    private static final int MAX_CROSS_SIZE = 100;


    private final ArrayList<Shape> shapes = new ArrayList<>();
    private Shape selectedShape = null;
    private boolean dragEnabled = false;
    private int prevMouseX, prevMouseY;

    abstract static class Shape {
        protected int x, y;
        protected boolean selected;

        public Shape(int x, int y) {
            this.x = x;
            this.y = y;
            selected = false;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        abstract void present(Graphics g);

        void move(int x1, int y1, int x2, int y2) {
            int dx = x2 - x1;
            int dy = y2 - y1;
            x += dx;
            y += dy;
        }

        abstract boolean areCoordsInside(int x, int y);

        @Override
        public String toString() {
            return String.format("Shape: %d, %d", x, y);
        }
    }

    static class Circle extends Shape {
        private final int radius;

        public Circle(int x, int y, int radius) {
            super(x, y);
            this.radius = radius;
        }

        @Override
        void present(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.BLUE);
            g2.fillOval(x - radius, y - radius, radius * 2, radius * 2);
            if (selected) {
                g2.setColor(Color.RED);
                g2.setStroke(new BasicStroke(2));
                g2.drawOval(x - radius, y - radius, radius * 2, radius * 2);
            }
        }

        @Override
        boolean areCoordsInside(int x, int y) {
            int dx = this.x - x;
            int dy = this.y - y;
            return dx * dx + dy * dy < radius * radius;
        }

        @Override
        public String toString() {
            return String.format("Circle: %d, %d, %d", x, y, radius);
        }
    }

    static class Rectangle extends Shape {
        private final int width, height;

        Rectangle(int x, int y, int width, int height) {
            super(x, y);
            this.width = width;
            this.height = height;
        }

        @Override
        void present(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            g.setColor(Color.RED);
            g.fillRect(x - width / 2, y - height / 2, width, height);
            if (selected) {
                g2.setColor(Color.BLUE);
                g2.setStroke(new BasicStroke(2));
                g2.drawRect(x - width / 2, y - height / 2, width, height);
            }
        }

        @Override
        boolean areCoordsInside(int x, int y) {
            int widthHalf = width / 2;
            int heightHalf = height / 2;
            return x >= this.x - widthHalf && x <= this.x + widthHalf &&
                    y >= this.y - heightHalf && y <= this.y + heightHalf;
        }

        @Override
        public String toString() {
            return String.format("Rect: %d, %d, %d, %d,", x, y, width, height);
        }
    }

    static class Cross extends Shape {
        private final Rectangle widthRect;
        private final Rectangle heightRect;
        private final int width, height;

        public Cross(int x, int y, int width, int height) {
            super(x, y);
            this.width = width;
            this.height = height;
            heightRect = new Rectangle(x - width / 2, y - height / 2, width, height);
            widthRect = new Rectangle(x - height / 2, y - width / 2, height, width);
        }

        @Override
        void present(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            g.setColor(Color.GREEN);
            g.fillRect(x - width / 2, y - height / 2, width, height);
            g.fillRect(x - height / 2, y - width / 2, height, width);
            if (selected) {
                g2.setColor(Color.RED);
                g2.setStroke(new BasicStroke(2));
                g2.drawRect(x - width / 2, y - height / 2, width, height);
                g2.setStroke(new BasicStroke(2));
                g2.drawRect(x - height / 2, y - width / 2, height, width);
            }
        }

        boolean areCoordsInside(int x, int y) {
            int widthHalf = width / 2;
            int heightHalf = height / 2;
            return x >= this.x - heightHalf && x <= this.x + heightHalf &&
                    y >= this.y - widthHalf && y <= this.y + widthHalf ||
                    x >= this.x - widthHalf && x <= this.x + widthHalf &&
                            y >= this.y - heightHalf && y <= this.y + heightHalf;
        }

        public String toString() {
            return String.format("Cross: (%s), (%s)", heightRect, widthRect);
        }
    }


    class Canvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (var shape : shapes) {
                shape.present(g);
            }

        }
    }

    Problem05() {
        var canvas = new Canvas();
        canvas.setBackground(Color.DARK_GRAY);
        JFrame thisFrame = this;
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (selectedShape != null) {
                        selectedShape.setSelected(false);
                    }
                    selectedShape = null;

                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    for (int i = shapes.size() - 1; i >= 0; i--) {
                        var shape = shapes.get(i);
                        if (shape.areCoordsInside(mouseX, mouseY)) {
                            selectedShape = shape;
                            selectedShape.setSelected(true);
                            break;
                        }
                    }

                    if (selectedShape != null) {
                        dragEnabled = true;
                        prevMouseX = e.getX();
                        prevMouseY = e.getY();
                    }

                    canvas.repaint();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    for (int i = shapes.size() - 1; i >= 0; i--) {
                        var shape = shapes.get(i);
                        if (shape.areCoordsInside(mouseX, mouseY)) {
                            JOptionPane.showMessageDialog(thisFrame, shape);
                        }
                    }
                }
            }

            public void mouseReleased(MouseEvent e) {
                dragEnabled = false;
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragEnabled) {
                    selectedShape.move(prevMouseX, prevMouseY, e.getX(), e.getY());
                    prevMouseX = e.getX();
                    prevMouseY = e.getY();
                    canvas.repaint();
                }
            }
        });

        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (selectedShape != null) {
                        shapes.remove(selectedShape);
                        canvas.repaint();
                    }
                }
            }
        });
        canvas.requestFocus();

        var toolBar = new Canvas();
        toolBar.setBackground(Color.GRAY);
        toolBar.setLayout(new GridLayout(1, 3));
        setLayout(new BorderLayout());
        toolBar.setFocusable(true);
        canvas.requestFocus();
        add(canvas, BorderLayout.CENTER);
        add(toolBar, BorderLayout.SOUTH);

        var rectButton = new JButton("Rectangle");
        rectButton.addActionListener(e -> {
            int x = (int) (Math.random() * canvas.getWidth());
            int y = (int) (Math.random() * canvas.getHeight());
            int width = (int) (MIN_RECT_SIZE + Math.random() * (MAX_RECT_SIZE - MIN_RECT_SIZE));
            int height = (int) (MIN_RECT_SIZE + Math.random() * (MAX_RECT_SIZE - MIN_RECT_SIZE));
            shapes.add(new Rectangle(x, y, width, height));
            canvas.repaint();
            canvas.requestFocus();
        });
        toolBar.add(rectButton);
        var circleButton = new JButton("Circle");
        circleButton.addActionListener(e -> {
            int x = (int) (Math.random() * canvas.getWidth());
            int y = (int) (Math.random() * canvas.getHeight());
            int radius = (int) (MIN_CIRCLE_RADIUS + Math.random() * (MAX_CIRCLE_RADIUS - MIN_CIRCLE_RADIUS));
            shapes.add(new Circle(x, y, radius));
            canvas.repaint();
            canvas.requestFocus();
        });
        toolBar.add(circleButton);
        var crossButton = new JButton("Cross");
        crossButton.addActionListener(e -> {
            int x = (int) (Math.random() * canvas.getWidth());
            int y = (int) (Math.random() * canvas.getHeight());
            int width = (int) (MIN_CROSS_SIZE + Math.random() * (MAX_CROSS_SIZE - MIN_CROSS_SIZE));
            int height = (int) (MIN_CROSS_SIZE + Math.random() * (MAX_CROSS_SIZE - MIN_CROSS_SIZE));
            shapes.add(new Cross(x, y, width / 3, height * 2));
            canvas.repaint();
            canvas.requestFocus();
        });
        toolBar.add(crossButton);
    }


    public static void main(String[] args) {
        var frame = new Problem05();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Graphics Editor");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
