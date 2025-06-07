package Models.Structures;

public class FarmLand extends Structures {
    Structures FarmLand = new Structures(50,0,30,1,3,50,0) ;
    public FarmLand(int structureHealth, int goldProduction, int foodProduction, int structurelevel, int structuremaxlevel, int structureCost,int unitSpace) {
        super(structureHealth, goldProduction, foodProduction, structurelevel, structuremaxlevel, structureCost,unitSpace);
    }
}
