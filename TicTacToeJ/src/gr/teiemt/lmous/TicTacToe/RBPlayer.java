package gr.teiemt.lmous.TicTacToe;

/**
 * It Represents a RuleBased Player
 * 
 */
 class RBPlayer extends Player {

    public RBPlayer(char id) {
        super(id);
    }

    @Override
    public <T> Movement move(T par)  {
       Board board=(Board)par;
       Movement[] availM=board.possibleMoves();
       for (Movement mv : availM) {
           Board bd=new Board(board);
           bd.setPlayerMove(this, mv);
           if (getId()==bd.win()) return mv;
       }
       for (Movement mv : availM) {
           Board bd=new Board(board);
           bd.setPlayerMove(getOpponent(), mv);
           if (getOpponent().getId()==bd.win()) return mv;
       }
       return availM[0];
    }
}
