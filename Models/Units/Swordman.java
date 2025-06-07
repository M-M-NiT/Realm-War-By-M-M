package Models.Units;

public class Swordman extends Units {
    Units Swordman = new Units(35,1,15,1,35,35,1,0);
    public Swordman(int unitHealth, int movementRange, int attackPower, int attackRange, int unitCost, int food, int space, int playerNum) {
        super(unitHealth, movementRange, attackPower, attackRange, unitCost, food, space, playerNum);
    }
}
