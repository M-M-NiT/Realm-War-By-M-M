package Models.Game;

import Controller.Merge;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public String message;
    public int currentPlayerIndex;
    public int timeLeft;
    private static Game instance ;
    protected List<Player>  players;
    private Board board;
    public Game(){
        players = new ArrayList<Player>();
        players.add(new Player());
        players.add(new Player());
    }
    public static void main(String[] args) {
        Merge.getInstance().getMenuPanel().startmenu();
    }
    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

        public Board getBoard(){
        return board;
        }

    public Player getPlayer(int index){
        return players.get(index);
    }
    public void set_timeLeft(int timeLeft){
       this.timeLeft = timeLeft;
    }

public void set_index(int index){
        this.currentPlayerIndex = index;
}
public void set_message(String message){
        this.message = message;
}
}
