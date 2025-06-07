package Models.Structures;

public class TownHall extends Structures {
    Structures TownHall = new Structures(200,50,50,1,3,0,50) ;
    public TownHall(int structureHealth, int goldProduction,int foodProduction ,int structurelevel, int structuremaxlevel,int structureCost,int unitSpace) {
        super(structureHealth, goldProduction,foodProduction, structurelevel, structuremaxlevel,structureCost,unitSpace);
    }
}
