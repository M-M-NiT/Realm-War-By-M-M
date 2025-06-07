package Models.Structures;

public class Tower extends Structures {
    Structures Tower = new Structures(175,0,0,1,3,50,0) ;
    public Tower(int structureHealth, int goldProduction, int foodProduction, int structurelevel, int structuremaxlevel, int structureCost, int unitSpace) {
        super(structureHealth, goldProduction, foodProduction, structurelevel, structuremaxlevel, structureCost, unitSpace);
    }
}
