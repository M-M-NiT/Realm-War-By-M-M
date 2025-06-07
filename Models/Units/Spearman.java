package Models.Units;

public class Spearman extends Units {
    Units spearman = new Units(25,1,10,2,25,25,1,0);
    public Spearman(int unitHealth, int movementRange, int attackPower, int attackRange, int unitCost, int food, int space, int playerNum) {
        super(unitHealth, movementRange, attackPower, attackRange, unitCost, food, space, playerNum);
    }
}
