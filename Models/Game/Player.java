package Models.Game;

import Models.Blocks.Blocks;
import Models.Blocks.EmptyBlock;
import Models.Blocks.ForestBlock;
import Models.Structures.*;
import Models.Units.Units;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Player{
    private String name;
    private int gold;
    private int food;
    private List<Structures> ownedStructures;
    private List<Units> ownedUnits;
    private List<Blocks> ownedBlocks;

    public Player(String name){
        ownedStructures = new ArrayList<Structures>();
        ownedBlocks = new ArrayList<Blocks>();
        ownedUnits= new ArrayList<Units>();
        this.name = name;
        this.gold = 100;
        this.food = 100;
        // ** Starting gold/unitfood values should update **
    }
    public String getName(){
        return name;
    }
    //gold related
    public void increaseGold(){
        for(Blocks blocks : ownedBlocks){

            if(blocks instanceof EmptyBlock){
                gold += 2;
            }
        }
        for(Structures structures : ownedStructures){

            if(structures instanceof GoldMine){
                gold += 4;
            }
            else if (structures instanceof TownHall){
                gold += 8;
            }
        }

    }
    public int getGold(){
        return gold;
    }
    public boolean hasEnoughGold(int value){
        return gold >= value;
    }
    public void setGold(int value){
        gold = value;
    }
    //unitfood related
    public void increaseFood(){
        for (Blocks block : ownedBlocks){
            if(block instanceof ForestBlock){
                food += 2;
            }
        }
        for (Structures structure : ownedStructures){
            if(structure instanceof FarmLand){
                food += 4;
            }
            else if(structure instanceof TownHall){
                food += 8;
            }
        }

    }
    public int getFood(){
        return food;
    }
    public boolean hasEnoughFood(int value){
        return food >= value;
    }
    public void setFood (int value){
        food = value;
    }

    public void addStructure(Structures structure){
        ownedStructures.add(structure);
    }

    public List<Units> getUnitsList(){
        return ownedUnits;
    }

    public void setUnitsList( Player player,List<Units> unitsList){
        ownedUnits = unitsList;
    }

    public List<Structures> getOwnedStructures(){
        return ownedStructures;
    }

    public List<Blocks> getOwnedBlocks() {
        return ownedBlocks;
    }
    public void addOwnedBlocks(Blocks block){

        ownedBlocks.add(block);
    }
    public void addUnits(Units unit){
        ownedUnits.add(unit);
}

    public boolean maxStructuresCount(){
        if(ownedStructures.size() < 10){
            return false;
        }
        return true;
    }
    public void deleteunit(Units unit){
        ownedUnits.remove(unit);

    }
    public void deleteblocked(Blocks blocks){
        ownedBlocks.remove(blocks);
    }
}

