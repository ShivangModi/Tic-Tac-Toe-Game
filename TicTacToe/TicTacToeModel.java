package TicTacToe;

import java.util.ArrayList;
import java.util.List;

// Model
public class TicTacToeModel {
    static TicTacToeModel instance;
    char[][] board;
    List<Observer> observers;
    Player currentPlayer;

    public TicTacToeModel() {
        board = new char[3][3];
        observers = new ArrayList<>();
        currentPlayer = null;
    }

    public static TicTacToeModel getInstance() {
        if (instance == null) {
            instance = new TicTacToeModel();
        }
        return instance;
    }

    public void addObservers(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    public void resetBoard() {
        board = new char[3][3];
        currentPlayer = null;
    }

    public void makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer.getSymbol();
            currentPlayer = currentPlayer.getNextPlayer();
            notifyObservers();
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '\u0000';
    }

    public char getBoardCell(int row, int col) {
        return board[row][col];
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinningCondition(char symbol) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }
}
