package UI.Windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSearchTest {
    private JFrame frame;
    private JTextField searchBar;
    private JButton searchButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleSearchTest window = new SimpleSearchTest();
            window.frame.setVisible(true);
        });
    }

    public SimpleSearchTest() {
        frame = new JFrame("Search Test");
        frame.setBounds(100, 100, 300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        searchBar = new JTextField();
        searchBar.setBounds(50, 20, 200, 30);
        frame.add(searchBar);

        searchButton = new JButton("GO");
        searchButton.setBounds(100, 70, 100, 30);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("GO button clicked");
            }
        });
        frame.add(searchButton);
    }
}
