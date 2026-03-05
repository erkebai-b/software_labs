import javax.swing.*;
import java.awt.*;

public class Problem01 extends JFrame {

    Problem01() {
        var colorPanel = new JPanel();
        colorPanel.setBackground(Color.RED);
        var toolbar = new JPanel();
        toolbar.setBackground(Color.DARK_GRAY);
        //toolbar.setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        add(colorPanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.SOUTH);

        var redButton = new JButton("RED");
        toolbar.add(redButton);
        var greenButton = new JButton("GREEN");
        toolbar.add(greenButton);
        var blueButton = new JButton("BLUE");
        toolbar.add(blueButton);


    }

    public static void main(String[] args) {
        var frame = new Problem01();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("First GUI App");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
