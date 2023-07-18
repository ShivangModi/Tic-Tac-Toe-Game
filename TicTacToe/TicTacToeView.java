package TicTacToe;

// View
public class TicTacToeView implements Observer {
    TicTacToeModel model;

    public TicTacToeView(TicTacToeModel model) {
        this.model = model;
        model.addObservers(this);
    }

    @Override
    public void update() {
        displayBoard();
    }

    public void displayBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("| " + model.getBoardCell(row, col) + " ");
            }
            System.out.println("|\n-------------");
        }
        System.out.println();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
