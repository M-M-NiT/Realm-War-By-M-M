package Models.Game;

import Models.Blocks.Blocks;
import Models.Blocks.EmptyBlock;
import Models.Blocks.ForestBlock;
import Models.Blocks.VoidBlock;
import Models.Structures.*;
import View.MenuPanel;

import java.util.Random;

public class Board {
   public MenuPanel menu = new MenuPanel();
   public Blocks s = new Blocks(1, 0);
   public Blocks[][] grid = new Blocks[12][12];



//
//   public void setTownHall() {
//      TownHall townHall = new TownHall();
//      TownHall townHall2 = new TownHall();
//      grid[1][1].setStructure(townHall);
//      grid[10][10].setStructure(townHall2);
//   }
public void create_blocks(){

   for (int j = 0; j< 12; j++) {
   int i = 0;
   grid[i][j] =  new VoidBlock(i, j);
}


   for (int j = 0; j < 12; j++) {
      int i = 11;
      grid[i][j] =  new VoidBlock(i, j);
   }
   for (int i = 1;  i < 11; i++) {
      int j = 0;
      grid[i][j] =   new VoidBlock(i, j);
   }
   for (int i = 1; i < 11; i++) {
      int j=11;
      grid[i][j] =   new VoidBlock(i, j);
   }
   Random rand = new Random();
   int temp1 = new Random().nextInt(2,5);
   for (int p = 0; p < temp1; p++) {
      int i = rand.nextInt(1, 11);
      int j = rand.nextInt(1, 11);
      if (!((i == 1 && j == 1) || (i == 10 && j == 10) || (i == 1 && j == 2) || (i==2 && j == 2) || (i==2 && j==1) ||
              (i==9 && j==10 ) || (i==9 && j==9) || i==10 && j==9)) {
         grid[i][j] = new VoidBlock(i, j);
      }
   }
         int temp = rand.nextInt(20, 30);
         for (int p = 0; p < temp; p++) {
            int i = rand.nextInt(1, 11);
            int j = rand.nextInt(1, 11);
            if (!((i == 1 && j == 1) || (i == 10 && j == 10) || (i == 1 && j == 2) || (i==2 && j == 2) || (i==2 && j==1) ||
                    (i==9 && j==10 ) || (i==9 && j==9) || i==10 && j==9)) {
               if (!(grid[i][j] instanceof VoidBlock) ){
                  grid[i][j] = new ForestBlock(i, j);
               }
            }
         }
         for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
               if (!(grid[i][j] instanceof VoidBlock)){
                  if (!(grid[i][j] instanceof ForestBlock)) {
                     grid[i][j] = new EmptyBlock(i, j);
                  }
               }


            }
         }


}
   public void show(){
      menu.createmap();
      build_TownHall();
      for (int i = 0; i < 12; i++) {
         for (int j = 0; j < 12; j++) {
            if (grid[i][j] instanceof VoidBlock) {
               menu.show_void_blocks(i,j);
            }
            if (grid[i][j] instanceof ForestBlock) {
               menu.show_forest_blocks(i,j);
            }
            if (grid[i][j] instanceof EmptyBlock) {
               menu.show_empty_blocks(i,j);
            }
         }
      }
   }

public void build_TownHall(){
   TownHall townHall_Player1 = new TownHall();
   TownHall townHall_Player2 = new TownHall();
   grid[1][1].setStructure(townHall_Player1);
   grid[10][10].setStructure(townHall_Player2);
   Game.getInstance().getPlayer(0).addStructure(townHall_Player1);
   Game.getInstance().getPlayer(1).addStructure(townHall_Player2);
}
   //index[0] == player 1
   //index[1] == player 2

public void build_Barrack(int i, int j,int index){
   Barrack barrack = new Barrack();
   grid[i][j].setStructure(barrack);
   Game.getInstance().getPlayer(index).addStructure(barrack);

}
public void build_Farmland(int i, int j,int index){
   FarmLand farmLand = new FarmLand();
   grid[i][j].setStructure(farmLand);
   Game.getInstance().getPlayer(index).addStructure(farmLand);

}
public void build_GoldMine(int i, int j,int index){
   GoldMine goldMine = new GoldMine();
   grid[i][j].setStructure(goldMine);
   Game.getInstance().getPlayer(index).addStructure(goldMine);


}
public void build_Tower(int i, int j,int index){
   Tower tower = new Tower();
   grid[i][j].setStructure(tower);
   Game.getInstance().getPlayer(index).addStructure(tower);

}
}



