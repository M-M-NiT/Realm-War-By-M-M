package Models.Structures;

import Models.Game.Game;
import Models.Units.Peasant;
import Models.Units.Units;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public class Barrack extends Structures {
    public Barrack(){
        super(100,1,3,50,2,10,0) ;
    }

    @Override
    public void upgrade() {
        if(Level < maxLevel){
            Level++;
            //lower parts should change
            Health += 1;
            unitSpace += 1;
        }
    }

    @Override
    public String getType() {
        return "Barrack";
    }
public boolean CanAddUnits(){
        int count = 0;
        for(Units units : Game.getInstance().getPlayer(0).getUnitsList()){
            if(units != null){
                count++;
            }
        }
        return count <= unitSpace;
}




public void add_units_space(){

}
}