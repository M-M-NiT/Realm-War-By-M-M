package Models.Players;

import Models.Blocks.Blocks;
import Models.Structures.TownHall;

public class Board {
   Blocks[][] blocks = new Blocks[10][10];
   public void run() {
      for (int p = 0; p < 10; p++) {
         for (int j = 0; j < 10; j++) {
            blocks[p][j] = new Blocks();
         }
      }
      TownHall townHall1 = new TownHall() ;
      TownHall townHall2 = new TownHall() ;
      blocks[0][0].setStructure(townHall1);
      blocks[9][9].setStructure(townHall2);

   }


}
