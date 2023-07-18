package TicTacToe;

public class UserPlayer extends Player {
    MoveStrategy moveStrategy;
    public UserPlayer(char symbol) {
        super("User", symbol);
        moveStrategy = new UserMoveStrategy();
    }

    @Override
    public int[] getNextMove(TicTacToeModel model) {
        return moveStrategy.getNextMove(model);
    }
}
