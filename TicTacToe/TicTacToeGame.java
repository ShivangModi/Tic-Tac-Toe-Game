package TicTacToe;

public class TicTacToeGame {
    public static void main(String[] args) {
        TicTacToeModel model = TicTacToeModel.getInstance();
        TicTacToeView view = new TicTacToeView(model);
        TicTacToeController controller = new TicTacToeController(model, view);
        controller.startGame();
    }
}
