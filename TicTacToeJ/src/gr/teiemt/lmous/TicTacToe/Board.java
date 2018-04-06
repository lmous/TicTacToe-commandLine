/**
 * @author Lefteris Moussiades
 * @since 20/09/2015
 */
package gr.teiemt.lmous.TicTacToe;

/**
 * Represents a TicTacToe board
 *
 * @author Lefteris
 */
public class Board {

    private final char[][] board;

    /**
     * marks free positions on the board
     */
    public static final char EMPTYCELL = ' ';

    /**
     * Constructor of class Board. Creates a TicTacToe board. All cells are
     * initialized to EMPTYCELL
     */
    public Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTYCELL;
            }
        }
    }

    /**
     * Creates a duplicate of its parameter source
     *
     * @param source
     */
    public Board(Board source) {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(source.board[i], 0, board[i], 0, 3);
        }
    }

    /**
     * Makes a move automatically for Player p. It is invoked when only 1
     * position is free on the board and Player p turns to play
     *
     * @param p
     */
    void autoMove(Player p) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTYCELL) {
                    board[i][j] = p.getId();
                }
            }
        }
    }
    /**
     * It Display the Board in command line mode
     */
    void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.println("-------");
            System.out.print(i);
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("-------");
    }

    /**
     * It sets the Movement mv of Player p on the calling board
     * @param p
     * @param mv 
     */
    public void setPlayerMove(Player p, Movement mv) {
        board[mv.getRow()][mv.getClmn()] = p.getId();
    }

    /**
     * 
     * @param row
     * @param clmn
     * @return the id of Player who has played on board position row,clmn
     * if no Player has played on board position row,clmn returns EMPTYCELL 
     */
    char get(int row, int clmn) {
        return board[row][clmn];
    }

    /**
     * 
     * @return the number of free board positions
     */
    public int freePositions() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTYCELL) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private char lineWin(int ln) {
        if ((board[ln][0] != EMPTYCELL)
                && (board[ln][0] == board[ln][1])
                && (board[ln][0] == board[ln][2])) {
            return board[ln][0];
        }
        return EMPTYCELL;
    }

    private char columnWin(int clmn) {
        if ((board[0][clmn] != EMPTYCELL)
                && (board[0][clmn] == board[1][clmn])
                && (board[1][clmn] == board[2][clmn])) {
            return board[0][clmn];
        }
        return EMPTYCELL;
    }

    private char diagonalWin() {
        if ((board[0][0] != EMPTYCELL)
                && (board[0][0] == board[1][1])
                && (board[0][0] == board[2][2])) {
            return board[0][0];
        }
        if ((board[2][0] != EMPTYCELL)
                && (board[2][0] == board[1][1])
                && (board[2][0] == board[0][2])) {
            return board[2][0];
        }
        return EMPTYCELL;
    }

    /**
     *
     * @return the sign of the winner. If a winner does not exist returns
     * EMPTYCELL;
     */
    public char win() {
        char rslt;
        for (int i = 0; i < 3; i++) {
            if ((rslt = lineWin(i)) != EMPTYCELL) {
                return rslt;
            }
            if ((rslt = columnWin(i)) != EMPTYCELL) {
                return rslt;
            }
        }
        return diagonalWin();
    }

    /**
     *
     * @return an array containing the available Movement of this board
     */
    public Movement[] possibleMoves() {
        Movement[] rVal;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTYCELL) {
                    cnt++;
                }
            }
        }
        if (cnt == 0) {
            return null;
        }
        rVal = new Movement[cnt];

        cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTYCELL) {
                    rVal[cnt++] = new Movement(i, j);
                }
            }
        }
        return rVal;
    }
    
    /**
     * 
     * @param m Specifies a board position
     * @return true if board position at m.row, m.clmn is an EMPTYCELL
     */
    public boolean emptyAt(Movement m) {
        return board[m.getRow()][m.getClmn()] == EMPTYCELL;
    }
}
