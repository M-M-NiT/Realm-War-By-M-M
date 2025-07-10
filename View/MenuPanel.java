package View;

//import Controller.Merge;

import javax.swing.*;
import java.awt.*;

public class MenuPanel {
    private JFrame frame ;
  private JPanel panel;
    private JPanel userpanel;
  public JButton[][] button = new JButton[12][12];

//
    public MenuPanel() {
       frame = new JFrame("Realm-War");
      panel = new JPanel(new GridLayout(12,12,5,5));
        userpanel = new JPanel(new BorderLayout());

  }

public void createmap() {
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(false);
    frame.setLocationRelativeTo(null);
    frame.setResizable(true);
    JLabel label = new JLabel("userpanel");
    for(int i = 0; i < 12; i++) {
        for (int j = 0; j < 12; j++) {
            button[i][j] = new JButton();
            button[i][j].setPreferredSize(new Dimension(5, 5));
        }
    }


for (int i = 0; i < 12; i++) {
    for (int j = 0; j < 12; j++) {
        panel.add(button[i][j]);
    }

    userpanel.add(label);
    userpanel.setPreferredSize(new Dimension(100, 100));
    frame.add(panel, BorderLayout.CENTER);
    frame.add(userpanel, BorderLayout.SOUTH);
    frame.setVisible(true);
}
}
public void show_void_blocks(int i , int j) {
    button[i][j].setBackground(Color.BLACK);
    }


public void show_empty_blocks(int i,int j){
        if(i==1 && j==1){
            button[i][j].setBackground(Color.BLUE);
        }
        else if(i==10 && j==10){
            button[i][j].setBackground(Color.RED);

        }else {
            button[i][j].setBackground(Color.GRAY);
        }
}
public void show_forest_blocks(int i , int j){
        button[i][j].setBackground(Color.GREEN);

}
}