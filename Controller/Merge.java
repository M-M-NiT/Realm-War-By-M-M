package Controller;

import Models.Game.Game;
import Models.Game.GameController;
import View.MenuPanel;

//package Controller;
//
//import Models.Blocks.ForestBlock;
//import Models.Game.Board;
//import View.MenuPanel;
//
//import java.awt.*;
//
public class Merge {
    private static Merge instance ;
    protected MenuPanel menuPanel;
    private static Merge instance1;
    protected GameController gameController;
    public Merge(){
        menuPanel = new MenuPanel();
        gameController = new GameController();
    }
public static Merge getInstance(){
        if(instance== null){
           instance = new Merge();
        }
        return instance;
}
public static Merge getInstance1(){
        if(instance1== null){
            instance1 = new Merge();
        }
        return instance1;
}
public MenuPanel getMenuPanel() {
        return menuPanel;
}
public GameController getGameController() {
        return gameController;
}

//    MenuPanel menuPanel ;
//    Board board ;
//public Merge(MenuPanel menuPanel) {
//    this.menuPanel = menuPanel;
//    board = new Board();
//}
//    public void test() {
//    board.run();
//
//    for (int i = 0; i < 12 ; i++) {
//        for (int j = 0; j < 12; j++) {
//            if(board.grid[i][j] instanceof ForestBlock){
//                    menuPanel.button[i][j].setBackground(Color.GREEN);
//            }
//        }
//    }
//        board.setTownHall();
//        if (board.grid[10][10].getStructure() != null && board.grid[1][1].getStructure() != null) {
//            menuPanel.button[10][10].setBackground(Color.RED);
//            menuPanel.button[1][1].setBackground(Color.BLUE);
//        }
//    }

}
