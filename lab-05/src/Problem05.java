import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Problem05 extends JFrame {

    private static final int CELL_X_COUNT = 8;
    private static final int CELL_Y_COUNT = 8;
    private int robotX = 0;
    private int robotY = 0;

    class Canvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int cellSizeX = getWidth() / CELL_X_COUNT;
            int cellSizeY = getHeight() / CELL_Y_COUNT;

            for (int y = 0; y < CELL_Y_COUNT; y++) {
                for (int x = 0; x < CELL_X_COUNT; x++) {
                    int scrX = x * cellSizeX;
                    int scrY = y * cellSizeY;
                    g.setColor((x + y) % 2 == 0 ? Color.BLACK : Color.WHITE);
                    g.fillRect(scrX, scrY, cellSizeX, cellSizeY);
                    if (x == robotX && y == robotY) {
                        g.setColor(Color.RED);
                        g.fillOval(scrX, scrY, cellSizeX, cellSizeY);
                    }
                }
            }
        }
    }

    Problem05() {
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> {
                        if (robotY > 0) robotY--;
                        repaint();
                    }
                    case KeyEvent.VK_DOWN -> {
                        if (robotY < CELL_Y_COUNT - 1) robotY++;
                        repaint();
                    }
                    case KeyEvent.VK_LEFT -> {
                        if (robotX > 0) robotX--;
                        repaint();
                    }
                    case KeyEvent.VK_RIGHT -> {
                        if (robotX < CELL_X_COUNT - 1) robotX++;
                        repaint();
                    }
                }
            }
        });

        var mainPanel = new Canvas();
        mainPanel.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        var frame = new Problem05();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Move robot");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getKeyListeners();
    }
}

