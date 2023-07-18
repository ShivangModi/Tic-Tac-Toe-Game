package TicTacToe;

import java.util.Scanner;

public class TicTacToeController {
    TicTacToeModel model;
    TicTacToeView view;
    Scanner scanner;

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.print("Enter 'user' to play against a human or 'ai' to play against AI:- ");

        String playerType = scanner.nextLine();
        System.out.println();

        Player player1 = PlayerFactory.createPlayer("user", 'X');
        Player player2 = PlayerFactory.createPlayer(playerType, 'O');

        assert player1 != null;
        player1.setNextPlayer(player2);

        assert player2 != null;
        player2.setNextPlayer(player1);

        model.setCurrentPlayer(player1);
        while (true) {
            Player currentPlayer = model.getCurrentPlayer();
            view.displayMessage("Player " + currentPlayer.getSymbol() + "'s turn");

            int[] move = currentPlayer.getNextMove(model);
            Command makeMoveCommand = new MakeMoveCommand(model, move[0], move[1]);
            makeMoveCommand.execute();

            if (checkGameEnd()) {
                System.out.println("Game over!");
                break;
            }
        }

        System.out.print("Do you want to play again? (y/n):- ");
        String playAgain = scanner.nextLine();

        System.out.println();
        if (playAgain.equalsIgnoreCase("y")) {
            Command restartCommand = new RestartGameCommand(model);
            restartCommand.execute();
            startGame();
        }
    }

    private boolean checkGameEnd() {
        TicTacToeModel model = TicTacToeModel.getInstance();
        if (model.checkWinningCondition('X')) {
            view.displayMessage("Player X wins!");
            return true;
        } else if (model.checkWinningCondition('O')) {
            view.displayMessage("Player O wins!");
            return true;
        } else if (model.isBoardFull()) {
            view.displayMessage("It's a draw!");
            return true;
        }
        return false;
    }
}
