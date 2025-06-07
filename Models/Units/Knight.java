package Models.Units;

public class Knight extends Units {
    Units Knight = new Units(50, 2, 20, 1, 50, 50, 1, 0);

    public Knight(int unitHealth, int movementRange, int attackPower, int attackRange, int unitCost, int food, int space, int playerNum) {
        super(unitHealth, movementRange, attackPower, attackRange, unitCost, food, space, playerNum);
    }
}
