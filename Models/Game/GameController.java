package Models.Game;

import Controller.Merge;
import Models.Blocks.Blocks;
import Models.Structures.Structures;
import Models.Structures.Tower;
import Models.Units.Units;
import View.MenuPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.TimerTask;

public class GameController {
    private Game game;
    private Board board = new Board();
    public int currentPlayerIndex = 0;
    public String message = "Game";
    public Timer timer ;

    private Merge merge;


        public void startGame() {
            merge = Merge.getInstance();
            game = Game.getInstance();
            board.create_blocks();
            board.show();

            // اجرای نوبت اول
            processTurn(game.getPlayer(currentPlayerIndex));
        }

    public void processTurn(Player player) {

        merge = Merge.getInstance();
        game = Game.getInstance();
        Merge.getInstance1().getGameController().collectResources(player);
        Merge.getInstance1().getGameController().payMaintenance(player);
        merge.getMenuPanel().showname(player.getName());
        merge.getMenuPanel().showgold(player.getGold());
        merge.getMenuPanel().showfood(player.getFood());
        merge.getMenuPanel().showmassage(message);
        final int[] timeLeft = {61};



Merge.getInstance1().getGameController().timer= new Timer(1000, null);
        Merge.getInstance1().getGameController().timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft[0] > 0) {
                    timeLeft[0]--;
                    System.out.println("Time Left: " + timeLeft[0]);
                    merge.getMenuPanel().showtime(timeLeft[0]);

                } else {
                    Merge.getInstance1().getGameController().timer.stop();
                    System.out.println("Turn Ended");
                    Merge.getInstance1().getGameController().change_player_turn();
                    Merge.getInstance1().getGameController().processTurn(game.getPlayer(currentPlayerIndex));
                }
            }
        });

        Merge.getInstance1().getGameController().timer.start();
//        allowPlayerAction(player);
//        applySpecialEffects(player);


    }

    public void collectResources(Player player){
        player.increaseGold();
        player.increaseFood();
    }

    private void payMaintenance(Player player){
        int requiredGold = 0;
if(player.getOwnedStructures() == null){
    return;
}

        for(Blocks block : player.getOwnedBlocks()){
            if(block.getStructure() == null){
                continue;
            }
            Structures structure = block.getStructure();
            requiredGold += structure.getMaintenanceCost();
            //needs update
        }
        player.setGold(player.getGold() - requiredGold);
        //Food Maintenance
        int requiredfood = 0;
        int totalfood = player.getFood();

if(player.getUnitsList() == null){
    return;
}
        for (Units unit : player.getUnitsList()){
            requiredfood += unit.getUnitfood();
        }
        if (totalfood < requiredfood){
            ArrayList<Units> remainingUnits = new ArrayList<>();
            int currentFood = totalfood;
            for (Units unit : player.getUnitsList()){
                if(currentFood > unit.getUnitfood()){}
                currentFood -= unit.getUnitfood();
                remainingUnits.add(unit);
            }
            player.setUnitsList(player, remainingUnits);
        }
        else { player.setFood(totalfood - requiredfood);
        }

        //Gold Maintenance

    }

//    private void allowPlayerAction(Player player){
//        while(true){
//            String choice = "";
//            switch (choice){
//                case "addUnit" : Board.addUnit(0,0,currentPlayerIndex); break; //Shoud Update
//
//                case "buildStructure" : Board.addStructure(0,0,currentPlayerIndex ,player); break; //Should Update
//
//                case "upgradeStructure" :
//            }
//        }
//    }

//    private void resolveDamage(Player player){
//        if (player.getUnitsList() == null){
//            return;
//        }
//        for(Units unit : player.getUnitsList()){
//            int UnitX = unit.getX();
//            int UnitY = unit.getY();
//            int range = unit.getAttackRange();
//            int damage = unit.getAttackPower();
//            for(int dx = -range; dx <= range; dx++){
//                for(int dy = -range; dy <= range; dy++){
//                    if(Math.abs(dx) + Math.abs(dy) > range){
//                        continue;
//                    }
//                    int tx = UnitX + dx;
//                    int ty = UnitY + dy;
//                    if(!board.isInsideBoard(tx, ty)){
//                        continue;
//                    }
//
//                    Blocks block = board.getBlock(tx, ty);
//                    if(block == null){
//                        continue;
//                    }
//
//                    if(!(block.getStructure() == null)){
//                        Structures targetStructure = block.getStructure();
//                        if (!(targetStructure.getOwner() == player)){
//                            targetStructure.takeDamage(damage);
//                        }
//                        if(targetStructure.getHealth() <= 0){
//                            block.removeStructure();
//                        }
//                    }
//
//                    Units targetUnit = block.getUnit();
//                    if(!(targetUnit.getPlayerNum() == currentPlayerIndex)){
//                        targetUnit.takeDamage(damage);
//                    }
//                    if(targetUnit.getUnitHealth() <= 0){
//                        Blocks targetUnitBlock = new Blocks(tx, ty);
//                        targetUnitBlock.removeUnit();
//                    }
//                }
//            }
//        }
//        for(Structures structure : player.getOwnedStructures()){
//            if(!(structure instanceof Tower)){
//                continue;
//            }
//            int StructureX = structure.getX();
//            int StructureY = structure.getY();
//            int range = 3; //Set range of Towers / might need an update
//            int damage = structure.getDamage();
//
//            for(int dx = -range; dx <= range; dx++){
//                for(int dy = -range; dy <= range; dy++){
//                    if(Math.abs(dx) + Math.abs(dy) > range){
//                        continue;
//                    }
//                    int tx = StructureX + dx;
//                    int ty = StructureY + dy;
//
//                    if(!board.isInsideBoard(tx, ty)){
//                        continue;
//                    }
//
//                    Blocks block = board.getBlock(tx, ty);
//                    if(block == null || !block.hasUnit()){
//                        continue;
//                    }
//
//                    Units targetUnit = block.getUnit();
//                    if(!(targetUnit.getPlayerNum() == currentPlayerIndex)){
//                        targetUnit.takeDamage(damage);
//                    }
//                    if(targetUnit.getUnitHealth() <= 0){
//                        block.removeUnit();
//                    }
//                }
//            }
//        }
//    }
//
//    private void applySpecialEffects(Player player){
//        MenuPanel menuPanel = new MenuPanel();
//        int i = menuPanel.Block_Row;
//        int j = menuPanel.Block_Col;
//        ArrayList<Units> units = new ArrayList<>(player.getUnitsList());
//        for (Units unit : units){
//            unit.getDamageAmplification(board,i,j);
//            // check getDamageAmplification in Unit class
//        }
//    }
public void change_player_turn(){

    if(Merge.getInstance1().getGameController().timer != null && Merge.getInstance1().getGameController().timer.isRunning()){
        Merge.getInstance1().getGameController().timer.stop();
    }
    currentPlayerIndex = (currentPlayerIndex + 1) % 2;
}


}
