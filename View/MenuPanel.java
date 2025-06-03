package View;

import javax.swing.*;
import java.awt.*;

public class MenuPanel {
    private JFrame frame ;
    private JPanel panel;
    private JPanel userpanel;
    public MenuPanel() {
        frame = new JFrame("Realm-War");
        panel = new JPanel(new GridLayout(10,10,5,5));
        userpanel = new JPanel(new BorderLayout());
    createmap();
    }

    public  static void main(String[] args) {
        MenuPanel panel = new MenuPanel();
    }
public void createmap(){
        frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(false);
    frame.setLocationRelativeTo(null);
    frame.setResizable(true);
    JLabel label = new JLabel("userpanel");
        for(int i = 0; i < 100; i++){
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(10,10));
            button.setBackground(Color.GRAY);
            panel.add(button);
        }
        userpanel.add(label);
        userpanel.setPreferredSize(new Dimension(100,100));
        frame.add(panel, BorderLayout.CENTER);
        frame.add(userpanel, BorderLayout.SOUTH);
    frame.setVisible(true);
}

}
