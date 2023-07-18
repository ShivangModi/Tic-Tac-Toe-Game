package TicTacToe;

public class RestartGameCommand implements Command {
    TicTacToeModel model;

    public RestartGameCommand(TicTacToeModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.resetBoard();
    }
}
