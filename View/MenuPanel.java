package View;

//import Controller.Merge;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuPanel {
    private JFrame frame ;
  private JPanel panel;
    private JPanel userpanel;
    private JPanel informationpanel;
    private JPanel timerpanel;
    private JPanel actionpanel;
    private GridBagConstraints gbc;
    private GridBagConstraints infogbc;
    private GridBagConstraints timergbc;
    private GridBagConstraints actiongbc;
    private int timeLeft = 31;
    private Timer timer;
  public JButton[][] button = new JButton[12][12];

//
    public MenuPanel() {
       frame = new JFrame("Realm-War");
      panel = new JPanel(new GridLayout(12,12,1,1));
        userpanel = new JPanel(new GridBagLayout());
         gbc = new GridBagConstraints();
        informationpanel = new JPanel(new GridBagLayout());
        infogbc = new GridBagConstraints();
        timerpanel = new JPanel(new GridBagLayout());
        timergbc = new GridBagConstraints();
        actionpanel = new JPanel(new GridBagLayout());
        actiongbc = new GridBagConstraints();


  }

public void createmap() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int panelHeight = (int) (screenHeight * 0.7);
        int userpanelHeight = screenHeight - panelHeight;
        int buttonHeight = panelHeight / 12;
        int buttonWidth = screenWidth / 12;

    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(false);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    panel.setPreferredSize(new Dimension(screenWidth,panelHeight));
    for(int i = 0; i < 12; i++) {
        for (int j = 0; j < 12; j++) {
            button[i][j] = new JButton();
            button[i][j].setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        }
    }


for (int i = 0; i < 12; i++) {
    for (int j = 0; j < 12; j++) {
        panel.add(button[i][j]);
    }
}


userpanel.setPreferredSize(new Dimension(screenWidth, userpanelHeight));
informationpanel.setPreferredSize(new Dimension(screenWidth/4, userpanelHeight));
informationpanel.setBorder(BorderFactory.createLineBorder(Color.RED));
timerpanel.setPreferredSize(new Dimension(screenWidth/4, userpanelHeight));
timerpanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
actionpanel.setPreferredSize(new Dimension(screenWidth/2, userpanelHeight));
actionpanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
gbc.fill = GridBagConstraints.BOTH;
gbc.gridy = 0;
gbc.gridx = 0;
gbc.weightx = 0.25;
userpanel.add(informationpanel, gbc);
gbc.gridx = 1;
gbc.weightx = 0.25;
userpanel.add(timerpanel, gbc);
gbc.gridx = 2;
gbc.weightx = 0.5;
userpanel.add(actionpanel, gbc);




JLabel playername = new JLabel("Player x Turn: ");
JLabel goldRatio = new JLabel("Gold : 30 ");
JLabel foodRatio = new JLabel("Food  : 20 ");





JLabel timeleft = new JLabel();
timer = new Timer(1000, e -> {
    timeLeft -= 1;
    if (timeLeft >= 0) {
        timeleft.setText("Time Left: " + timeLeft + " s");
    }else {
        timer.stop();
    }

});
timer.start();
JButton endturn = new JButton("End Turn");
endturn.setPreferredSize(new Dimension(100, 50));



JLabel textbox = new JLabel("This is for show actions in the Game");
textbox.setHorizontalAlignment(SwingConstants.CENTER);
textbox.setVerticalAlignment(SwingConstants.CENTER);
textbox.setBorder(BorderFactory.createLineBorder(Color.RED));
JLabel Build_structures_text = new JLabel("Build Structures: ");
    Build_structures_text.setHorizontalAlignment(SwingConstants.CENTER);
    Build_structures_text.setVerticalAlignment(SwingConstants.CENTER);
JLabel Add_Units_text = new JLabel("Add Units: ");
String[] structures_name = {"Barrack","FarmLand","GoldMine","Tower"};
    Add_Units_text.setHorizontalAlignment(SwingConstants.CENTER);
    Add_Units_text.setVerticalAlignment(SwingConstants.CENTER);
String[] units_name = {"Peasant","Spearman","Swordman","Knight"};
JComboBox <String> structures_selector = new JComboBox<>(structures_name);
JComboBox <String> units_selector = new JComboBox<>(units_name);
JButton move_button = new JButton("Move");
move_button.setPreferredSize(new Dimension(50, 50));
JButton levelup_button = new JButton("Level Up");
levelup_button.setPreferredSize(new Dimension(50, 50));
    actiongbc.fill = GridBagConstraints.HORIZONTAL;
    actiongbc.insets = new Insets(15, 15, 15, 15);
    actiongbc.weighty = 1.0;
   actiongbc.weightx = 1.0;
actiongbc.gridx = 0;
actiongbc.gridy = 0;
actiongbc.gridwidth = 3;
actionpanel.add(textbox, actiongbc);
actiongbc.gridy = 1;
actiongbc.gridwidth = 1;
    actionpanel.add(Build_structures_text, actiongbc);
actiongbc.gridx = 1;

    actionpanel.add(structures_selector, actiongbc);

//String selected_struct = (String) structures_selector.getSelectedItem();
actiongbc.gridx = 0;
actiongbc.gridy = 2;
    actionpanel.add(Add_Units_text, actiongbc);
    actiongbc.gridx = 1;
    actionpanel.add(units_selector, actiongbc);
    actiongbc.gridx = 2;
    actiongbc.gridy = 1;
    actionpanel.add(move_button, actiongbc);
    actiongbc.gridy=2;
    actionpanel.add(levelup_button, actiongbc);
   // String selected_units = (String) units_selector.getSelectedItem();






infogbc.gridx = 0;
infogbc.gridy = 0;
infogbc.insets = new Insets(0, 10, 20, 10);
informationpanel.add(playername,infogbc);
infogbc.gridy = 1;
infogbc.insets = new Insets(10, 10, 10, 10);
informationpanel.add(goldRatio,infogbc);
infogbc.gridy = 2;
infogbc.insets = new Insets(20, 10, 1, 10);
informationpanel.add(foodRatio,infogbc);



timergbc.gridx = 0;
timergbc.gridy = 0;
timergbc.insets = new Insets(10,10,10,10);
timerpanel.add(timeleft,timergbc);
timergbc.gridy = 1;
timerpanel.add(endturn,timergbc);





    frame.add(panel, BorderLayout.CENTER);
    frame.add(userpanel, BorderLayout.SOUTH);
    frame.setVisible(true);

}
public void show_void_blocks(int i , int j) {
    button[i][j].setBackground(Color.BLACK);
    button[i][j].setEnabled(false);
    }


public void show_empty_blocks(int i,int j){
        if(i==1 && j==1){
            button[i][j].setBackground(Color.BLUE);
        }
        else if(i==10 && j==10){
            button[i][j].setBackground(Color.RED);

        }else {
            button[i][j].setBackground(new Color(211,211,211));
        }
}
public void show_forest_blocks(int i , int j){
        button[i][j].setBackground(Color.GREEN);

}

}