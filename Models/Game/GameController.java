package Models.Game;

import Models.Blocks.Blocks;
import Models.Units.Units;

import java.util.ArrayList;

public class GameController {
    private Game game;
    private Board board;
    private int currentPlayerIndex = 0;

    public void startGame(){
        game = Game.getInstance();
        board = new Board();
        board.create_blocks();
        board.show();

        while(!(Board.isGameOver())){
            processTurn(game.getPlayer(currentPlayerIndex));
            currentPlayerIndex = (currentPlayerIndex + 1) % 2;
            //customized for 2 players / need update if more players
        }
    }

    private void processTurn(Player player){
        collectResources(player);
        payMaintenance(player);
        allowPlayerAction(player);
        applySpecialEffects(player);
        resolveDamage(player);
    }

    private void collectResources(Player player){

    }

    private void payMaintenance(Player player){
        int totalfood = 0;
        int requiredfood = 0;

        int requiredgold = 0;

        totalfood = player.getFood();

        ArrayList<Units> units = new ArrayList<>(player.getUnitsList(player));
        for (Units unit : units){
            requiredfood += unit.getUnitfood();
        }
        if (totalfood < requiredfood){

        }

    }

    private void allowPlayerAction(Player player){

    }

    private void resolveDamage(Player player){

    }

    private void applySpecialEffects(Player player){

    }

}
