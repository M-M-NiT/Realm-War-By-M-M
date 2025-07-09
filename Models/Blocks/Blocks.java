package Models.Blocks;

import Models.Game.Player;
import Models.Structures.Structures;
import Models.Units.Units;

public abstract class Blocks {
protected boolean isOwned;
protected Player owner;

private Structures structure;
public void setStructure(Structures structure) {
    this.structure = structure;
}
public Structures getStructure() {
    return structure;
}
}
