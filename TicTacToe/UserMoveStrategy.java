package TicTacToe;

import java.util.Scanner;

public class UserMoveStrategy  implements MoveStrategy {
    @Override
    public int[] getNextMove(TicTacToeModel model) {
        System.out.print("Enter row (0-2) and column (0-2) for your move (e.g., 1 2): ");

        Scanner scanner = new Scanner(System.in);
        return new int[]{scanner.nextInt(), scanner.nextInt()};
    }
}
