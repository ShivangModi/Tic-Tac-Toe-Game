package TicTacToe;

public class MakeMoveCommand implements Command {
    TicTacToeModel model;
    int row, col;

    public MakeMoveCommand(TicTacToeModel model, int row, int col) {
        this.model = model;
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute() {
        model.makeMove(row, col);
    }
}
