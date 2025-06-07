package Models.Units;

public class Peasant extends Units {
    Units peasant = new Units(10,1,5,1,15,15,1,0);
    public Peasant(int unitHealth, int movementRange, int attackPower, int attackRange, int unitCost, int food, int space, int playerNum) {
        super(unitHealth, movementRange, attackPower, attackRange, unitCost, food, space, playerNum);
    }
}
