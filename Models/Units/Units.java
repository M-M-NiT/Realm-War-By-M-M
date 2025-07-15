package Models.Units;

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
}
