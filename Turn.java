public class Turn {
    public static final int GAME_SPACES = 8; // Spaces[0-8]


    // requests move from human player
    public static String movePrompt(String player) {
        String move;
        // move
        System.out.printf("\nPlayer %s: What's your move? \n", player);
        move = Main.in.nextLine();
        return move.toUpperCase();
    }


    // updates board with X or O
    public static String[][] gameplay(String[][] board, int x, int y, String player) {
        board[x][y] = player;
        return board;
    }


    // verifies move is playable, move is accepted as index within spaces
    public static boolean moveVerification(int moveIndex, Space[] availableSpaces) {
        if (moveIndex >= 0) {
            // check if entered a playable move and marks as played
            if (availableSpaces[moveIndex].playable) {
                availableSpaces[moveIndex].playable = false;
                return true;
            }
        }
        return false;   // move was not playable
    }


    // accepts move, checks if playable,
    public static int inputMove(String move, Space[] availableSpaces, String[][] board, int tally, String player) {
        int x = -1;
        int y = -1;
        int moveIndex = -1;

        // translating move into its index within spaces[]
        for (int i = 0; i <= GAME_SPACES; i++) {
            if (move.equals(availableSpaces[i].display)) {
                x = availableSpaces[i].coordX;
                y = availableSpaces[i].coordY;
                moveIndex = i;
            }
        }

        // move validity check using index
        if (!moveVerification(moveIndex, availableSpaces)) {
            System.out.println("Sorry, that move is not valid. Please enter another move.");
            return tally;
        } else {    // move was valid
            // update board
            String[][] updatedBoard = gameplay(board, x, y, player);    // declaration for updatedBoard
            Grid.printBoard(updatedBoard);
            tally++;
            return tally;
        }
    }



    public static boolean winCheck (String[][]board){
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


    public static boolean winAnnounce(String[][] board, String player, int tally) {
        boolean win = winCheck(board);

        if (win) {
            System.out.printf("\nPlayer %s wins!\n", player);
            return true;
        } else if (tally == GAME_SPACES + 1) {
            System.out.print("\nThis game is a draw!\n");
            return true;
        } else {
            return false;
        }
    }

}
