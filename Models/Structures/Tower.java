package Models.Structures;

public class Tower extends Structures {
    public Tower() {
        super(175,0,0,1,3,50,0,0,50) ;
    }

    @Override
    public void upgrade() {
        if(Level < maxLevel){
            Level++;
            Health += 1;
            damage += 1;
            maintenanceCost += 1;
        }
    }

    @Override
    public String getType() {
        return "Tower";
    }
}
