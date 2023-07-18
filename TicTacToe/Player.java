package TicTacToe;

// Player (Base class for UserPlayer & AIPlayer)
abstract class Player {
    String name;
    char symbol;
    Player nextPlayer;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public abstract int[] getNextMove(TicTacToeModel model);
}
