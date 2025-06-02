package Models.Structures;

public abstract class Structures {
    private int structureHealth;
    private int structurecost;
    private int structurelevel;
    private int structuremaxlevel;

    public int getStructureHealth() {
        return structureHealth;
    }

    public void setStructureHealth(int structureHealth) {
        this.structureHealth = structureHealth;
    }

    public int getStructurecost() {
        return structurecost;
    }

    public void setStructurecost(int structurecost) {
        this.structurecost = structurecost;
    }

    public int getStructurelevel() {
        return structurelevel;
    }

    public void setStructurelevel(int structurelevel) {
        this.structurelevel = structurelevel;
    }

    public int getStructuremaxlevel() {
        return structuremaxlevel;
    }

    public void setStructuremaxlevel(int structuremaxlevel) {
        this.structuremaxlevel = structuremaxlevel;
    }
}
