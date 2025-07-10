package Models.Structures;

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

public void add_units(){


}
public void add_units_space(){

}
}