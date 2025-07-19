package Models.Units;

public class Knight extends Units {

    public Knight() {
        super(50, 2, 20, 1, 5, 50, 1);
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
        return "Knight";
    }
}
