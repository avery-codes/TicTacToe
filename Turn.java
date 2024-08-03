public class Turn {

    public static String[][] gameplay(String[][] board, int x, int y, String player){
        board[x][y] = player;
        return board;
    }


    public static int inputMove(String move, Space[] spaces, String[][] board, int tally, String player) {
        int x = -1;
        int y = -1;
        int GAME_SPACES = 8; // Spaces[0-8]
        boolean validMove = false;

        // move input
        for (int i = 0; i <= GAME_SPACES; i++) {
            if (move.equals(spaces[i].display)) {
                x = spaces[i].coordX;
                y = spaces[i].coordY;

                // check if playable move, else mark as played
                if (!spaces[i].playable) {
                    System.out.printf("Sorry, %s has already been played.\n", move);
                } else {
                    spaces[i].playable = false;
                    validMove = true;
                    break;
                }
            }
        }

        // move validity check
        if (!validMove) {
            System.out.println("Sorry, that move is invalid. Please enter another move.");
            return tally;
        }

        // update board
        String[][] updatedBoard = gameplay(board, x, y, player);    // declaration for updatedBoard
        Grid.printBoard(updatedBoard);

        // check for win/draw
        if (winCheck(updatedBoard)) {
            System.out.printf("\nPlayer %s wins!\n", player);
            return -1;
        } else if (tally == GAME_SPACES) {
            System.out.print("\nThis game is a draw!\n");
            return -1;
        } else {
            tally++;
            Grid.printAvailable(spaces);
        }
        return tally;
    }



    public static boolean winCheck(String[][] board) {
        // row and column checks
        for (int i = 1; i <= 5; i += 2) {
            // row check
            if (!board[i][1].equals(" ") && board[i][1].equals(board[i][3]) && board[i][1].equals(board[i][5])) {
                return true;
            }
            // column check
            if (!board[1][i].equals(" ") && board[1][i].equals(board[3][i]) && board[1][i].equals(board[5][i])) {
                return true;
            }
        }

        // diagonal checks
        // top left to bottom right
        if (!board[1][1].equals(" ") && board[1][1].equals(board[3][3]) && board[1][1].equals(board[5][5])) {
            return true;
        }
        // bottom left to top right
        if (!board[5][1].equals(" ") && board[5][1].equals(board[3][3]) && board[5][1].equals(board[1][5])) {
            return true;
        }
        return false;
    }
}
