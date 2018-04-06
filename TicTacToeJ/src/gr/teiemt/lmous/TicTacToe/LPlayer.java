/**
 * @author Lefteris Moussiades
 * @since 20/09/2015
 */
package gr.teiemt.lmous.TicTacToe;

import java.util.Scanner;

/**
 * Represents a live Player, i.e. a player who supplies input from the keyboard
 * 
 */
public class LPlayer extends Player {

    public LPlayer(char id) {
        super(id);
    }

    @Override
    public <T> Movement move(T par) {
        Scanner cIn = new Scanner(System.in);
        int r, c;
        System.out.print("dwse grammi : ");
        r = cIn.nextInt();
        System.out.println();
        System.out.print("dwse stili : ");
        c = cIn.nextInt();
        return new Movement(r, c);
    }

}
