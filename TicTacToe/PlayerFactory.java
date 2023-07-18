package TicTacToe;

// Factory
public class PlayerFactory {
    public static Player createPlayer(String playerType, char symbol) {
        if (playerType.equalsIgnoreCase("user")) {
            return new UserPlayer(symbol);
        } else if (playerType.equalsIgnoreCase("ai")) {
            return new AIPlayer(symbol);
        }
        return null;
    }
}
