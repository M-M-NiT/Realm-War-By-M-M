package Models.Units;

public class Peasant extends Units {
    public Peasant() {
        super(10,1,1,1,15,15,1,0);
    }
    public void attack(){

    }
    @Override
    public String getType(){
        return "Peasant";
    }
}
