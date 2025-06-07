package Models.Structures;

import Models.Units.Units;

public class GoldMine extends Structures {
    Structures GoldMine = new Structures(150,50,0,1,3,20,0) ;
    public GoldMine(int structureHealth, int goldProduction, int foodProduction, int structurelevel, int structuremaxlevel, int structureCost, int unitSpace) {
        super(structureHealth, goldProduction, foodProduction, structurelevel, structuremaxlevel, structureCost, unitSpace);
    }
}
