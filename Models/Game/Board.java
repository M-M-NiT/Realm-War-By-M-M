package Models.Game;

import Models.Blocks.Blocks;
import Models.Blocks.EmptyBlock;
import Models.Blocks.ForestBlock;
import Models.Blocks.VoidBlock;
import Models.Structures.Structures;
import Models.Structures.TownHall;
import View.MenuPanel;

import java.util.Random;

public class Board {
   public MenuPanel menu = new MenuPanel();
   public Blocks s = new Blocks(1, 0);
   public Blocks[][] grid = new Blocks[12][12];
   private Structures TownHall;

//
//   public void run() {
//      for (int p = 0; p < 12; p++) {
//         for (int j = 0; j < 12; j++) {
//            // new EmptyBlock([p][j])
//         }
//      }
//
//      Random rand = new Random();
//      int temp = rand.nextInt(20, 30);
//      for (int p = 0; p < temp; p++) {
//         if (grid[rand.nextInt(10)][rand.nextInt(10)] instanceof EmptyBlock) {
//            grid[rand.nextInt(1, 11)][rand.nextInt(1, 11)] = new ForestBlock(0, 0);
//         } else {
//            p--;
//         }
//      }
//   }
//
//   public void setTownHall() {
//      TownHall townHall = new TownHall();
//      TownHall townHall2 = new TownHall();
//      grid[1][1].setStructure(townHall);
//      grid[10][10].setStructure(townHall2);
//   }

   public void create_void_blocks() {

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

   }
   public void create_forest_blocks() {

      Random rand = new Random();
      int temp = rand.nextInt(20, 30);
      for (int p = 0; p < temp; p++) {
         int i = rand.nextInt(1,11);
         int j = rand.nextInt(1,11);
         if ( ! ((i==1&&j==1) || (i==10 && j==10)) ) {
         grid[i][j] =   new ForestBlock( i,j);}
      }
   }
   public void create_empty_blocks() {
      for (int i = 1; i < 11; i++) {
         for (int j = 1; j < 11; j++) {
            if (!(grid[i][j] instanceof ForestBlock)  ) {
               grid[i][j]= new EmptyBlock(i, j);
            }


         }
      }

   }
   public void show(){
      menu.createmap();
      set_townhall();
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
public void set_townhall(){
   grid[1][1].setStructure(TownHall);
   grid[10][10].setStructure(TownHall);
}
}



