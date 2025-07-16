package Models.Game;

import Models.Blocks.Blocks;
import Models.Blocks.EmptyBlock;
import Models.Blocks.ForestBlock;
import Models.Blocks.VoidBlock;
import Models.Structures.*;
import Models.Units.*;
import View.MenuPanel;

import java.util.Random;

public class Board {
   public TownHall townHall_Player1 = new TownHall();
  public TownHall townHall_Player2 = new TownHall();
   public MenuPanel menu = new MenuPanel();
   public Blocks s = new Blocks(1, 0);
   public  Blocks[][] grid = new Blocks[12][12];
   public static boolean player1Won = true;

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

    SetDefaultBlocks();
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

      grid[1][1].setStructure(townHall_Player1);
      grid[10][10].setStructure(townHall_Player2);
      Game.getInstance().getPlayer(0).addStructure(townHall_Player1);
      Game.getInstance().getPlayer(1).addStructure(townHall_Player2);
   }
   //index[0] == player 1
   //index[1] == player 2

   public void build_Barrack(int i, int j,int index){
    if(can_build_structure_and_units(i,j,index)) {


        Barrack barrack = new Barrack();
        grid[i][j].setStructure(barrack);
        Game.getInstance().getPlayer(index).addStructure(barrack);
        if(grid[i][j] instanceof ForestBlock) {
            changeforestblock(i,j,index);
        }
    }
   }
   public void build_Farmland(int i, int j,int index){
    if(can_build_structure_and_units(i,j,index)) {

        FarmLand farmLand = new FarmLand();
        grid[i][j].setStructure(farmLand);
        Game.getInstance().getPlayer(index).addStructure(farmLand);
        if(grid[i][j] instanceof ForestBlock) {
            changeforestblock(i,j,index);
        }
    }
   }
   public void build_GoldMine(int i, int j,int index){
    if(can_build_structure_and_units(i,j,index)) {

        GoldMine goldMine = new GoldMine();
        grid[i][j].setStructure(goldMine);
        Game.getInstance().getPlayer(index).addStructure(goldMine);
        if(grid[i][j] instanceof ForestBlock) {
            changeforestblock(i,j,index);
        }
    }

   }
   public void build_Tower(int i, int j,int index){
    if(can_build_structure_and_units(i,j,index)) {

        Tower tower = new Tower();
        grid[i][j].setStructure(tower);
        Game.getInstance().getPlayer(index).addStructure(tower);
        if(grid[i][j] instanceof ForestBlock) {
            changeforestblock(i,j,index);
        }
    }
   }

   public Blocks getBlock(int x, int y) {
      if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
         return grid[x][y];
      }
      return null;
   }

   public  boolean isGameOver(){
   Board board = Game.getInstance().getBoard();
      Blocks block1 = board.getBlock(1,1);
      Blocks block2 = board.getBlock(10,10);
 if(townHall_Player1.townhallisover()){
    block1.setStructure(null);
 }else if(townHall_Player2.townhallisover()){
    block2.setStructure(null);
 }

      if(!(block1.getStructure() instanceof TownHall)){
         player1Won = false;
         return true;
      }
      if(block2.getStructure() instanceof TownHall){
         player1Won = true;
         return true;
      }
      return false;
   }
  public void SetDefaultBlocks(){
   Game.getInstance().getPlayer(0).addOwnedBlocks(grid[1][2]);
   Game.getInstance().getPlayer(0).addOwnedBlocks(grid[2][2]);
   Game.getInstance().getPlayer(0).addOwnedBlocks(grid[2][1]);
   Game.getInstance().getPlayer(1).addOwnedBlocks(grid[9][10]);
   Game.getInstance().getPlayer(1).addOwnedBlocks(grid[9][9]);
   Game.getInstance().getPlayer(1).addOwnedBlocks(grid[10][9]);
  }
  public void GetBlocks(int i, int j, int index){
   Game.getInstance().getPlayer(index).addOwnedBlocks(grid[i][j]);

  }
public void addpeasant(int i, int j, int index){
    if(can_build_structure_and_units(i,j,index)) {
        Peasant peasant = new Peasant();
        grid[i][j].setUnit(peasant);
        Game.getInstance().getPlayer(index).addUnits(peasant);
    }
}
public void addKnight(int i, int j, int index){
    if(can_build_structure_and_units(i,j,index)) {


        Knight knight = new Knight();
        grid[i][j].setUnit(knight);
        Game.getInstance().getPlayer(index).addUnits(knight);
    }
}
public void addSpearman(int i, int j, int index){
    if(can_build_structure_and_units(i,j,index)) {
        Spearman spearman = new Spearman();
        grid[i][j].setUnit(spearman);
        Game.getInstance().getPlayer(index).addUnits(spearman);
    }
}
public void addSwordman(int i, int j, int index){
    if(can_build_structure_and_units(i,j,index)) {
        Swordman swordman = new Swordman();
        grid[i][j].setUnit(swordman);
        Game.getInstance().getPlayer(index).addUnits(swordman);
    }
}
public boolean can_build_structure_and_units(int i, int j, int index){
    if(!(Game.getInstance().getPlayer(index).getOwnedBlocks().contains(grid[i][j]))){
        return false;
    }
    if (grid[i][j].getStructure() != null){
        return false;
    }
    if (grid[i][j].getUnit() != null){
        return false;
    }
   return true;
}
public void changeforestblock(int i, int j, int index){
    grid[i][j] =null;
    grid[i][j] =  new EmptyBlock(i, j);
}
public boolean can_move_unit(int first_row, int first_col, int second_row, int second_col, int index, Units unit){
    if(!(Game.getInstance().getPlayer(index).getOwnedBlocks().contains(grid[second_row][second_col]))){
        return false;
    }
    if(grid[first_row][first_col].getStructure() != null){
        return false;
    }
    if(grid[second_row][second_col].getUnit() != null){
        return false;
    }
    if (!(check_movementrange(first_row, first_col, second_row, second_col, unit))){
        return false;

    }
    return true;
}
public boolean check_movementrange(int first_row, int first_col, int second_row, int second_col, Units unit){
   int a=first_row - unit.getMovementRange();
   int b=first_col - unit.getMovementRange();
   int c=first_row + unit.getMovementRange();
   int d=first_col + unit.getMovementRange();
    if (second_row == a && second_col == b){
        return true;
    }
    if (second_row == a && second_col == first_col){
        return true;
    }
    if (second_row == a && second_col == d){
        return true;
    }
    if(second_row == first_row && second_col == a){
        return true;
    }
    if(second_row == first_row && second_col == d){
        return true;
    }
    if(second_row == c && second_col == b){
        return true;
    }
    if(second_row == c && second_col == first_col){
        return true;
    }
    if(second_row == c && second_col == d){
        return true;

    }
    return false;
}
}