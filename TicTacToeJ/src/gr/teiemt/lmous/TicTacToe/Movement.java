/**
 * @author Lefteris Moussiades
 * @since 20/09/2015
 */

package gr.teiemt.lmous.TicTacToe;


/**
 * Represents a Movement in TicTacToe board. A Movement consists of two integer that indicate
 the getRow and column of a board position
 * @author Lefteris Moussiades
 */
public class Movement {
    private int r;
    private int c;
    
    public Movement(int row, int clmn) {
        r=row;
        c=clmn;
    }
    public int getRow() {return r;}
    public int getClmn() {return c;}
    
}
