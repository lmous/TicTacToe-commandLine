/**
 * @author Lefteris Moussiades
 * @since 20/09/2015
 */
package gr.teiemt.lmous.TicTacToe;

/**
 * class Game is the organizing class of TicTacToe project. It contains main
 * method
 */
public class Game {

    Board board;
    Player p1;
    Player p2;

    /**
     * Creates a Game consisting of a board and two player
     *
     * @param p1 Player 1, opponent of Player 1
     * @param p2 Player 2, opponent of Player 1
     */
    Game(Player p1, Player p2) {
        board = new Board();
        this.p1 = p1;
        this.p2 = p2;
        p1.setOpponents(p2);
        //srand (time(NULL));
    }

    /**
     * Based on board.win() checks if there is a winner
     *
     * @return The Player who wins or null if there is no winner
     * @see gr.teiemt.lmous.TicTacToe.Board#win()
     */
    Player winner() {
        char winnerSign = board.win();
        if (p1.getId() == winnerSign) {
            return p1;
        }
        if (p2.getId() == winnerSign) {
            return p2;
        }
        return null;
    }

    /**
     * Starts a game
     *
     * @param p The Player who plays first
     * @return the Winner
     */
    Player play(Player p) {
        Player theWinner = null;
        Player current = p;

        do {
            Movement cell;
            if (board.freePositions() == 1) {
                board.autoMove(current);
            } else {
                cell = current.move(board);
                board.setPlayerMove(current, cell);
            }
            board.displayBoard();
            current = current.getOpponent();

        } while (board.freePositions() > 0
                && (theWinner = winner()) == null);

        return theWinner;
    }

    public static void main(String[] args)/*throws Exception*/ {
        Player p2 = new LPlayer('R');
        Player p1 = new MiniMaxPlayer('M');

        Game myGame = new Game(p1, p2);
        Player winner = myGame.play(p2);

        if (winner != null) {
            System.out.println("Winner is " + winner.getId());
        } else {
            System.out.println("withdraw ");
        }
    }

}
