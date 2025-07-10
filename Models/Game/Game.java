package Models.Game;

public class Game {
    public  static void main(String[] args) {
        Board board = new Board();
        board.create_void_blocks();
        board.create_forest_blocks();
        board.create_empty_blocks();
        board.show();
    }

}
