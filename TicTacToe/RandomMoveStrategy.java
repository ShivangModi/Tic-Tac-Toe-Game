package TicTacToe;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public int[] getNextMove(TicTacToeModel model) {
        int row, col;
        Random random = new Random();
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!model.isValidMove(row, col));

        return new int[]{row, col};
    }
}
