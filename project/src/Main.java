import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class Main extends JFrame {
    public static final int WIDTH1_PX = 700;
    public static final int HEIGHT1_PX = 500;
    public static final int FIELD_WIDTH = 20;
    public static final int FIElD_HEIGHT= 20;


    private Field field;

    class Snake extends JPanel {
        public Snake() {
            setBackground(Color.BLACK);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            //TODO
        }
    }

    public Main() {
        setSize(WIDTH1_PX, HEIGHT1_PX);
        setTitle("Anaconda");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CardLayout layoutManager = new CardLayout();
        setLayout(layoutManager);

        //layoutManager.first(this);

        field = new Field(FIELD_WIDTH,FIElD_HEIGHT);

        Snake snake = new Snake();
        add(snake);

    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
