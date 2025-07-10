package Models.Game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Game instance ;
    protected List<Player>  players;
    public Game(){
        players = new ArrayList<Player>();
        players.add(new Player("Player1"));
        players.add(new Player("Player2"));
    }
    public  static void main(String[] args) {
        Board board = new Board();
        board.create_blocks();
        board.show();
    }
    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }
public Player getPlayer(int index){
        return players.get(index);
}

}
