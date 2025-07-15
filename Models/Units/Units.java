package Models.Units;

import Models.Blocks.Blocks;
import Models.Blocks.ForestBlock;
import Models.Game.Board;

public class Units {
    protected int unitHealth;
    protected int movementRange;
    protected int attackPower;
    protected int attackRange;
    protected int unitCost;
    protected int unitfood;
    protected int space;
    protected int playerNum;
    public Units(int unitHealth,int movementRange,int attackPower,int attackRange,int unitCost,int food,int space,int playerNum) {
        this.unitHealth = unitHealth;
        this.movementRange = movementRange;
        this.attackPower = attackPower;
        this.attackRange= attackRange;
        this.unitCost = unitCost;
        this.unitfood = food;
        this.space = space;
        this.playerNum = playerNum;
    }

    // NEED X,Y VALUE FOR UNITS;

    public int getUnitHealth() {
        return unitHealth;
    }

    public void setUnitHealth(int unitHealth) {
        this.unitHealth = unitHealth;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public void setMovementRange(int movementRange) {
        this.movementRange = movementRange;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackrange) {
        attackRange = attackrange;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }

    public int getUnitfood() {
        return unitfood;
    }

    public void setUnitfood(int unitfood) {
        this.unitfood = unitfood;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public void attack(){

    }

    public int getDamageAmplification(Board board) {
        Blocks block = board.getBlock(0,0);
        // **Need to add x,y values to units to multiply their damage if on forest block**
        if (block instanceof ForestBlock) {
            return (int) (this.getAttackPower() * 1.1); // Multiply value should update (exp : 1.1)
        }
        return this.getAttackPower();
    }

}
