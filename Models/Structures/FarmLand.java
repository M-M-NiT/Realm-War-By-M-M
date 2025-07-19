package Models.Structures;

public class FarmLand extends Structures {
    public FarmLand() {
        super(50,1,3,50,0,5,0) ;
    }
    private int food = 5;
    @Override
    public void upgrade() {
        if(Level < maxLevel) {
            Level++;
            //lower parts should change
            Health += 1;
            food += 1 ;
        }
    }

    @Override
    public String getType() {
        return "FarmLand";
    }

    public int food_producing(){
        return food;

    }
}
