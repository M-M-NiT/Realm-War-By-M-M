package Models.Game;

import Models.Blocks.Blocks;
import Models.Structures.Structures;
import Models.Structures.Tower;
import Models.Units.Units;
import View.MenuPanel;

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

        while(!(board.isGameOver())){
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

    public void collectResources(Player player){
        player.increaseGold();
        player.increaseFood();


    }

    private void payMaintenance(Player player){
        //Food Maintenance
        int requiredfood = 0;
        int totalfood = player.getFood();

        ArrayList<Units> units = new ArrayList<>(player.getUnitsList());
        for (Units unit : units){
            requiredfood += unit.getUnitfood();
        }
        if (totalfood < requiredfood){
            ArrayList<Units> remainingUnits = new ArrayList<>();
            int currentFood = totalfood;
            for (Units unit : units){
                if(currentFood > unit.getUnitfood()){}
                currentFood -= unit.getUnitfood();
                remainingUnits.add(unit);
            }
            player.setUnitsList(player, remainingUnits);
        }
        else { player.setFood(totalfood - requiredfood);
        }

        //Gold Maintenance
        int requiredGold = 0;

        for(Blocks block : player.getOwnedBlocks()){
            Structures structure = block.getStructure();
            requiredGold += structure.getMaintenanceCost();
            //needs update
        }
        player.setGold(player.getGold() - requiredGold);
    }

    private void allowPlayerAction(Player player){

    }

    private void resolveDamage(Player player){

    }

    private void applySpecialEffects(Player player){
        MenuPanel menuPanel = new MenuPanel();
        int i = menuPanel.Block_Row;
        int j = menuPanel.Block_Col;
        ArrayList<Units> units = new ArrayList<>(player.getUnitsList());
        for (Units unit : units){
            unit.getDamageAmplification(board,i,j);
            // check getDamageAmplification in Unit class
        }
    }

}
