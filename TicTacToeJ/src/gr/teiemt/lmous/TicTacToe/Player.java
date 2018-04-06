/**
 * @author Lefteris Moussiades
 * @since 20/09/2015
 */
package gr.teiemt.lmous.TicTacToe;

/**
 * Abstract class that represents a TicTacToe player. All TicTacToe Player
 * classes should extend from Player
 */
public abstract class Player {

    private final char id;
    private Player opponent;

    /**
     * Constructor
     *
     * @param id The id player uses, e.g. x or o etc.
     * 
     */
    public Player(char id) {
        this.id = id;
    }

    public char getId() {
        return id;
    }

    /**
     *
     * @param board
     * @return true if this Player wins the game
     */
    public boolean wins(Board board) {
        char wSign = board.win();
        return wSign == id;
    }

    /**
     * Updates this Player with her/his opponent Updates the opponent's opponent
     * with this Player
     *
     * @param p the opponent Player
     */
    public void setOpponents(Player p) {
        opponent = p;
        p.opponent = this;
    }

    public Player getOpponent() {
        return opponent;
    }

    /**
     * All TicTacToe Player classes should implement this method.
     *
     * @param par Typically receives as parameter a Board. 
     * However UI Applications that uses this project as a library may pass an Object of different Class.
     * @return Based on the status of the board, player "decides" the Movement
     */
    
    public abstract <T> Movement move(T par);
    
    
}
