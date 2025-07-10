package Models.Blocks;

import Models.Game.Game;
import Models.Game.Player;
import Models.Structures.Structures;
import Models.Units.Units;

public class Blocks {
protected int  block_row_address;
protected int  block_col_address;
protected boolean isOwned;
protected Player owner;
public Blocks(int block_row_address, int block_col_address) {
    this.block_col_address = block_col_address;
    this.block_row_address = block_row_address;
}
public int getBlock_row_address() {
    return block_row_address;
}
public int getBlock_col_address() {
    return block_col_address;

}
private Structures structure;
public void setStructure(Structures structure) {
    this.structure = structure;
}
public Structures getStructure() {

    return structure;
}


}
