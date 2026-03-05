import javax.swing.*;
import java.awt.*;

public class Problem04 extends JFrame {
    private static final int CELL_X_COUNT = 8;
    private static final int CELL_Y_COUNT = 8;

    static class Canvas extends JPanel {
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
                }
            }
        }
    }

    Problem04() {
        var mainPanel = new Canvas();
        mainPanel.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        var frame = new Problem04();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Chessboard");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
