import javax.swing.*;
import java.awt.*;

public class Problem02 extends JFrame {

    Problem02() {
        var colorPanel = new JPanel();
        colorPanel.setBackground(Color.RED);
        var colorSelectionPanel = new JPanel();
        colorSelectionPanel.setBackground(Color.DARK_GRAY);
        //colorSelectionPanel.setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        add(colorPanel, BorderLayout.CENTER);
        add(colorSelectionPanel, BorderLayout.SOUTH);

        var redButton = new JButton("RED");
        redButton.addActionListener(e -> colorPanel.setBackground(Color.RED));
        colorSelectionPanel.add(redButton);
        var greenButton = new JButton("GREEN");
        greenButton.addActionListener(e -> colorPanel.setBackground(Color.GREEN));
        colorSelectionPanel.add(greenButton);
        var blueButton = new JButton("BLUE");
        blueButton.addActionListener(e -> colorPanel.setBackground(Color.BLUE));
        colorSelectionPanel.add(blueButton);


    }

    public static void main(String[] args) {
        var frame = new Problem02();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Second GUI App");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
