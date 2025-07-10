//package Controller;
//
//import Models.Blocks.ForestBlock;
//import Models.Game.Board;
//import View.MenuPanel;
//
//import java.awt.*;
//
//public class Merge {
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
//}
