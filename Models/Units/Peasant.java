package Models.Units;

public class Peasant extends Units {
    public Peasant() {
        super(3,1,1,1,15,15,1);
    }
    public void attack(){

    }
    public void updrage() {
        unitHealth*=2;
        attackPower*=2;
        unitfood++;
    }
    @Override
    public String getType(){
        return "Peasant";
    }
}
