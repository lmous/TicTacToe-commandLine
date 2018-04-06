/**
 * @author Lefteris Moussiades
 * @since 20/09/2015
 */

package gr.teiemt.lmous.TicTacToe;

import javafx.animation.Timeline;

/**
 * This class extends Player and implements algorithm minimax in its move method 
 MiniMaxPlayer is a perfect TicTacToe Artificial Player
 * @author Lefteris
 */
public class MiniMaxPlayer extends Player {
    Movement currentMovement;

    public MiniMaxPlayer(char id) {
        super(id);
    }
    
    private int maxIdx(int[] tbl)  {
        int rVal=0, max=tbl[0];
        for (int i=1; i<tbl.length; i++)
            if (tbl[i] > max) {
                max=tbl[i];
                rVal=i;
            }
        return rVal;
}


    private int minIdx(int[] tbl) {
        int rVal=0, min=tbl[0];
        for (int i=1; i<tbl.length; i++)
            if (tbl[i] < min) {
                min=tbl[i];
                rVal=i;
            }
        return rVal;
    }
    
    private int minimax(Board board, Player p) {
        if (getOpponent().wins(board))
           return -1;
        
        if (wins(board)) return 1;
        if (board.freePositions()==0) return 0;
        Movement[] moves= board.possibleMoves(); 
        int[]  scores = new int[moves.length];

        for (int i=0; i<moves.length; i++) {
            Board newState=new Board(board);
            newState.setPlayerMove(p, moves[i]);
            scores[i]=minimax(newState, p.getOpponent());
        }

        if (this.equals(p)) {
            int maxScoreIdx=maxIdx(scores);
            currentMovement=moves[maxScoreIdx];
            return scores[maxScoreIdx];
        }
        else {
            int minScoreIdx=minIdx(scores);
            currentMovement=moves[minScoreIdx];
            return scores[minScoreIdx];
        }
    }
    
    @Override
    public <T> Movement move(T par) {
        Board board=(Board)par;
        minimax(board,this);
        return currentMovement;
    }
        
};




   