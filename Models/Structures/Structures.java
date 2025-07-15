package Models.Structures;

import Models.Game.Player;

    public abstract class Structures {
    protected int Health;
    protected int Level;
    protected int maxLevel;
    protected int buildingCost;
    protected int unitSpace;
    protected int maintenanceCost;
    protected int damage;

    public Structures(int structureHealth,  int structurelevel, int structuremaxlevel, int buildingCost ,int unitSpace ,int maintenanceCost ,int damage) {

    this.Health = structureHealth;
    this.Level = structurelevel;
    this.maxLevel = structuremaxlevel;
    this.buildingCost = buildingCost;
    this.unitSpace = unitSpace;
    this.maintenanceCost = maintenanceCost;
    this.damage = damage;
}

    public abstract void upgrade();

    public abstract String getType();

    public int getStructureHealth() {
        return Health;
    }

    public void setStructureHealth(int structureHealth) {
        this.Health = structureHealth;
    }



    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        this.Level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
    public void food_producing(){

    }
    public void gold_mining(){

    }
    public int getMaintenanceCost() {
        return maintenanceCost;
    }
    }
