package Models.Players;

import Models.Blocks.Blocks;
import Models.Blocks.EmptyBlock;
import Models.Blocks.ForestBlock;
import Models.Structures.TownHall;

import java.util.Random;

public class Board {
   Blocks[][] blocks = new Blocks[10][10];
   public void run() {
      for (int p = 0; p < 10; p++) {
         for (int j = 0; j < 10; j++) {
            blocks[p][j] = new EmptyBlock();
         }
      }

      Random rand = new Random();
      int temp = rand.nextInt(20,30) ;
      for (int p = 0; p < temp; p++) {
         if(blocks[rand.nextInt(10)][rand.nextInt(10)] instanceof EmptyBlock){
            blocks[rand.nextInt(10)][rand.nextInt(10)] = new ForestBlock();
            }
         else{ p--;
         }
      }
      }

      //      TownHall townHall1 = new TownHall() ;
//      TownHall townHall2 = new TownHall() ;
//      blocks[0][0].setStructure(townHall1);
//      blocks[9][9].setStructure(townHall2);


   }


}
