package Models.Structures;

public class FarmLand extends Structures {
    public FarmLand() {
        super(50,1,3,50,0,5,0) ;
    }

    @Override
    public void upgrade() {
        if(Level < maxLevel) {
            Level++;
            //lower parts should change
            Health += 1;

        }
    }

    @Override
    public String getType() {
        return "FarmLand";
    }
    public void food_producing(){

    }
}
