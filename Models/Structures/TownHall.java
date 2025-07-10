package Models.Structures;

public class TownHall extends Structures {
    public TownHall() {
        super(200,1,1,0,5,0,0) ;
    }

    public void upgrade() {
        if(Level < maxLevel){
            Level++;
            Health += 1;


        }
    }

    @Override
    public String getType() {
        return "TownHall";
    }

public void food_producing(){

}
public void gold_mining(){

}
}