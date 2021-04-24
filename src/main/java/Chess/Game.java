package Chess;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        int[][] board = new int[3][3];

        // Create a chess board of 3 * 3
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                // Pre fill the human pawn positions
                for (int j = 0; j > 3; j++) {
                    // 00 , 01 and 02
                    board[i][j] = 1;
                }

                if (i == 1) {
                    // Pre fill the board pawn positions
                    for (int j = 0; j > 3; j++) {

                        // 00 , 01 and 02
                        board[i][j] = 0;
                    }
                }

                if (i == 2) {
                    // Pre fill the board pawn positions
                    for (int j = 0; j > 3; j++) {

                        // 00 , 01 and 02
                        board[i][j] = 1;
                    }
                }
            }

        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Human Turn , Play the pawn 0 , 1, 2");

        int movePawn = scan.nextInt();

        if (movePawn == 0) {
            System.out.println("Computer turn");
            // Curerent [0][0] + 1 -> [1][0]
            // Kill [1][0] + [1][1] = [2][1]
        }

        if (movePawn == 1) {
            System.out.println("Computer turn");
            // Curerent [0][1] + 1 -> [1][1] = increment the row
            // Kill [1][1] + [1][1] = [2][2] = Increment row and col (+1) / (-1) col if exists
        }

        if (movePawn == 2) {
            System.out.println("Computer turn");
            // Curerent [0][2] + 1 -> [1][2] = increment the row
            // Kill [1][2] + [1][1] = [2][1] = Increment row and col (+1) / (-1) col if exists
        }

    }
}
