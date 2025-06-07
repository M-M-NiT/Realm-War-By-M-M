package View;

import javax.swing.*;
import java.awt.*;

public class MenuPanel {
    private JFrame frame ;
    private JPanel panel;
    private JPanel userpanel;
    public MenuPanel() {
        frame = new JFrame("Realm-War");
        panel = new JPanel(new GridLayout(12,12,5,5));
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
        for(int i = 0; i < 144; i++){
            int row = i/12;
            int col = i%12;
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(5,5));
            if(col == 0 || col == 11 || row == 0 || row == 11){
                button.setBackground(Color.BLACK);
            }else {
                button.setBackground(Color.GRAY);
            }


            panel.add(button);
        }

        userpanel.add(label);
        userpanel.setPreferredSize(new Dimension(100,100));
        frame.add(panel, BorderLayout.CENTER);
        frame.add(userpanel, BorderLayout.SOUTH);
    frame.setVisible(true);
}

}
