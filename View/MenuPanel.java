package View;

//import Controller.Merge;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Integer Block_Row =null;
    private Integer Block_Col =null;
    String currentAction =null;
    String units_selected = null;
    String structure_selected = null;
    private JLabel textbox;
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
        final int row= i;
        final int col = j;
        button[i][j].addActionListener(e ->{

        Choose_Block(row,col);

        });
        panel.add(button[i][j]);
    }
}


userpanel.setPreferredSize(new Dimension(screenWidth, userpanelHeight));
informationpanel.setPreferredSize(new Dimension(screenWidth/4, userpanelHeight));
//informationpanel.setBorder(BorderFactory.createLineBorder(Color.RED));
    informationpanel.setBackground(new Color(180,190,200));
timerpanel.setPreferredSize(new Dimension(screenWidth/4, userpanelHeight));
//timerpanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
timerpanel.setBackground(new Color(180,190,200));
actionpanel.setPreferredSize(new Dimension(screenWidth/2, userpanelHeight));
//actionpanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
actionpanel.setBackground(new Color(180,190,200));
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



information_menu("Ali",20,30);
timer_menu();
action_menu("This is for show actions in the Game");
















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
            ImageIcon icon = new ImageIcon(getClass().getResource("images/R.png"));
            Image scaledImage = icon.getImage().getScaledInstance(90,70,Image.SCALE_SMOOTH);
            ImageIcon icon2 = new ImageIcon(scaledImage);
            button[i][j].setIcon(icon2);
        }
        else if(i==10 && j==10){
            button[i][j].setBackground(Color.RED);
            ImageIcon icon = new ImageIcon(getClass().getResource("images/OIIL.png"));
            Image scaledImage = icon.getImage().getScaledInstance(100,60,Image.SCALE_SMOOTH);
            ImageIcon icon2 = new ImageIcon(scaledImage);
            button[i][j].setIcon(icon2);

        }else {
            button[i][j].setBackground(new Color(211,211,211));
        }
}
public void show_forest_blocks(int i , int j){
   button[i][j].setBackground(Color.green);
        ImageIcon icon = new ImageIcon(getClass().getResource("images/OIP.png"));
        Image scaledImage = icon.getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(scaledImage);
        button[i][j].setIcon(icon2);



}
public void information_menu(String name,int gold,int food){

    JLabel playername = new JLabel(name+ " 's Turn ");
    JLabel goldRatio = new JLabel("Gold : " + gold);
    JLabel foodRatio = new JLabel("Food  :  " + food);
    JButton Back_Button = new JButton("Back");

    infogbc.gridx = 0;
    infogbc.gridy = 0;
    infogbc.insets = new Insets(0, 10, 20, 10);
    informationpanel.add(playername,infogbc);
    infogbc.gridy = 1;
    infogbc.insets = new Insets(10, 10, 10, 10);
    informationpanel.add(goldRatio,infogbc);
    infogbc.gridy = 2;
    infogbc.insets = new Insets(20, 10, 10, 10);
    informationpanel.add(foodRatio,infogbc);
    infogbc.gridy = 3;
    infogbc.insets = new Insets(10, 10, 1, 10);
    Back_Button.setPreferredSize(new Dimension(100,80));
    Back_Button.setBackground(Color.ORANGE);
    Back_Button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            resetActionPanel();
        }
    });
    informationpanel.add(Back_Button,infogbc);

}
public void timer_menu(){
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
    endturn.setBackground(Color.MAGENTA);

    timergbc.gridx = 0;
    timergbc.gridy = 0;
    timergbc.insets = new Insets(10,10,10,10);
    timerpanel.add(timeleft,timergbc);
    timergbc.gridy = 1;
    timerpanel.add(endturn,timergbc);

}
public void action_menu(String action){
     textbox = new JLabel(action);
    textbox.setHorizontalAlignment(SwingConstants.CENTER);
    textbox.setVerticalAlignment(SwingConstants.CENTER);
    //textbox.setBorder(BorderFactory.createLineBorder(Color.RED));
    JLabel Build_structures_text = new JLabel("Build Structures: ");
    Build_structures_text.setHorizontalAlignment(SwingConstants.CENTER);
    Build_structures_text.setVerticalAlignment(SwingConstants.CENTER);
    JLabel Add_Units_text = new JLabel("Add Units: ");
    String[] structures_name = {"Barrack","FarmLand","GoldMine","Tower"};
    Add_Units_text.setHorizontalAlignment(SwingConstants.CENTER);
    Add_Units_text.setVerticalAlignment(SwingConstants.CENTER);
    String[] units_name = {"Peasant","Spearman","Swordman","Knight"};
    JComboBox <String> structures_selector = new JComboBox<>(structures_name);
    structures_selector.addActionListener(e -> {
        structure_selected = (String) structures_selector.getSelectedItem();
        currentAction = "build_structure";
        Block_Row = null;
        Block_Col = null;
        textbox.setText("Choose a Block : ");

    });
    JComboBox <String> units_selector = new JComboBox<>(units_name);
    units_selector.addActionListener(e -> {
         units_selected = (String) units_selector.getSelectedItem();
        currentAction ="add_unit";
        Block_Row = null;
        Block_Col = null;
        textbox.setText("Choose a Block : ");
    });
    JButton move_button = new JButton("Move");
    move_button.setPreferredSize(new Dimension(50, 50));
    move_button.setBackground(new Color(0,200,0));
    JButton levelup_button = new JButton("Level Up");
    levelup_button.setPreferredSize(new Dimension(50, 50));
    levelup_button.setBackground(Color.CYAN);
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
    actionpanel.add(levelup_button, actiongbc);
    actiongbc.gridy=2;
    actionpanel.add(move_button, actiongbc);
    // String selected_units = (String) units_selector.getSelectedItem();
}
    private void resetActionPanel() {
        currentAction = null;
        actionpanel.removeAll();
        action_menu("This is for show actions in the Game!!!");
        actionpanel.revalidate();
        actionpanel.repaint();
    }
private void set_structures(int i , int j,String structurename){
        switch (structurename){
            case "Barrack":
                ImageIcon p = new ImageIcon(getClass().getResource("images/Barrack.png"));
                Image scaledImage = p.getImage().getScaledInstance(80,60,Image.SCALE_SMOOTH);
                ImageIcon p2 = new ImageIcon(scaledImage);
                button[i][j].setIcon(p2);
                resetActionPanel();
                break;
            case "FarmLand":
                ImageIcon s = new ImageIcon(getClass().getResource("images/FarmLand.png"));
                Image scaledImage1 = s.getImage().getScaledInstance(80,60,Image.SCALE_SMOOTH);
                ImageIcon s2= new ImageIcon(scaledImage1);
                button[i][j].setIcon(s2);
                resetActionPanel();
                break;
            case "GoldMine":
                ImageIcon w = new ImageIcon(getClass().getResource("images/GoldMine.png"));
                Image scaledImage2 = w.getImage().getScaledInstance(80,60,Image.SCALE_SMOOTH);
                ImageIcon w2 = new ImageIcon(scaledImage2);
                button[i][j].setIcon(w2);
                resetActionPanel();
                break;
            case "Tower":
                ImageIcon k = new ImageIcon(getClass().getResource("images/Tesla.png"));
                Image scaledImage3 = k.getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH);
                ImageIcon k2 = new ImageIcon(scaledImage3);
                button[i][j].setIcon(k2);
                resetActionPanel();
                break;
        }

}
private void set_units(int i , int j,String unitname){
        switch (unitname){
            case "Peasant":
                ImageIcon p = new ImageIcon(getClass().getResource("images/worker.png"));
                Image scaledImage = p.getImage().getScaledInstance(80,60,Image.SCALE_SMOOTH);
                ImageIcon p2 = new ImageIcon(scaledImage);
                button[i][j].setIcon(p2);
                resetActionPanel();
                break;
             case "Spearman":
                 ImageIcon s = new ImageIcon(getClass().getResource("images/Goblin.png"));
                 Image scaledImage1 = s.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
                 ImageIcon s2= new ImageIcon(scaledImage1);
                 button[i][j].setIcon(s2);
                 resetActionPanel();
                 break;
             case "Swordman":
                 ImageIcon w = new ImageIcon(getClass().getResource("images/Barbar.png"));
                 Image scaledImage2 = w.getImage().getScaledInstance(80,60,Image.SCALE_SMOOTH);
                 ImageIcon w2 = new ImageIcon(scaledImage2);
                 button[i][j].setIcon(w2);
                 resetActionPanel();
                 break;
             case "Knight":
                 ImageIcon k = new ImageIcon(getClass().getResource("images/MegaKnight.png"));
                 Image scaledImage3 = k.getImage().getScaledInstance(80,60,Image.SCALE_SMOOTH);
                 ImageIcon k2 = new ImageIcon(scaledImage3);
                 button[i][j].setIcon(k2);
                 resetActionPanel();
                 break;
        }

}
private void Choose_Block(int row , int col){
        if("add_unit".equals(currentAction)){
            Block_Row = row;
            Block_Col = col;
            set_units(row,col,units_selected);
        } else if ("build_structure".equals(currentAction)) {
            Block_Row = row;
            Block_Col = col;
            set_structures(row,col,structure_selected);

        }


}

}