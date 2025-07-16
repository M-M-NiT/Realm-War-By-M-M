package Models.Units;

public class Swordman extends Units {
    public Swordman() {
        super(35,1,15,1,35,35,1,0);
    }
    public void attack(){

    }

    @Override
    public String getType() {
        return "Swordman";
    }
}
