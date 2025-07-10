package Models.Game;

import Models.Blocks.Blocks;
import Models.Structures.Structures;
import Models.Structures.Tower;
import Models.Structures.TownHall;
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
        this.name = name;
        this.gold = 100;
        this.food = 100;
        // ** Starting gold/unitfood values should update **
    }
    public String getName(){
        return name;
    }
    //gold related
    private void increaseGold(int value){
        gold += value;
    }
    public int getGold(){
        return gold;
    }
    public boolean hasEnoughGold(int value){
        return gold >= value;
    }
    //unitfood related
    private void increaseFood(int value){
        food += value;
    }
    public int getFood(){
        return food;
    }
    public boolean hasEnoughFood(int value){
        return food >= value;
    }

public void addStructure(Structures structure){
        ownedStructures.add(structure);
}
}
