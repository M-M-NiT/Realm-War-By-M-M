package Models.Structures;

public class TownHall extends Structures {
    public TownHall() {
        super(200,50,50,1,3,0,50,0,0) ;
    }

    public void upgrade() {
        if(Level < maxLevel){
            Level++;
            Health += 1;
            foodProduction += 1;
            goldProduction += 1;
            unitSpace += 1;
        }
    }

    @Override
    public String getType() {
        return "TownHall";
    }
}
