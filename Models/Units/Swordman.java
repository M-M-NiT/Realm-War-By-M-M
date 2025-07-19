package Models.Units;

public class Swordman extends Units {
    public Swordman() {
        super(35,1,15,1,35,35,1);
    }
    public void attack(){

    }

    @Override
    public void updrage() {
        unitHealth*=2;
        attackPower*=2;
        unitfood++;
    }

    @Override
    public String getType() {
        return "Swordman";
    }
}
