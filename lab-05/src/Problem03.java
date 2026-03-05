import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Problem03 extends JFrame {

    Problem03() {
        var mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                setTitle(String.format("%d, %d", e.getX(), e.getY()));
            }
        });
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        var frame = new Problem03();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Move mouse");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
