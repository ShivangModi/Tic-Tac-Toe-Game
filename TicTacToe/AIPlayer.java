package TicTacToe;

public class AIPlayer extends Player {
    MoveStrategy moveStrategy;
    public AIPlayer(char symbol) {
        super("AI", symbol);
        moveStrategy = new RandomMoveStrategy();
    }

    @Override
    public int[] getNextMove(TicTacToeModel model) {
        return moveStrategy.getNextMove(model);
    }
}
