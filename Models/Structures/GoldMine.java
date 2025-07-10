package Models.Structures;

import Models.Units.Units;

public class GoldMine extends Structures {
    public GoldMine() {
        super(150,1,3,20,0,5,0) ;
    }

    public void upgrade() {
        if(Level < maxLevel){
            Level++;
            Health += 1;

        }
    }

    @Override
    public String getType() {
        return "GoldMine";
    }
    public void gold_mining(){

    }
}