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
    public static boolean moveVerification(Space moveSpace) {
        if (moveSpace !=  null) {
            // check if entered a playable move and marks as played
            if (moveSpace.playable) {
               moveSpace.playable = false;
                return true;
            }
        }
        return false;   // move was not playable
    }



    // accepts move, checks if playable,
    public static int inputMove(String move, Space[] availableSpaces, String[][] board, int tally, String player) {
        Space moveSpace = null;

        for (int i = 0; i < availableSpaces.length; i++) {
            if (move.equals(availableSpaces[i].display)) {
                moveSpace = availableSpaces[i];
            }
        }

        // error control
        if (moveSpace == null) {
            System.out.println("Error getting move index. Please enter move again.");
            return tally;
        }

        // move validity check using index
        if (!moveVerification(moveSpace)){
            System.out.println("Sorry, that move is not valid. Please enter another move.");
            return tally;

        } else {    // move was valid
            // update board
            String[][] updatedBoard = gameplay(board, moveSpace.coordX, moveSpace.coordY, player);
            Grid.printBoard(updatedBoard);
            tally++;
        }
        return tally;
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


    public static int humanPlayer(String player, int tally, Space[] availableSpaces, String[][] board){
        String move = Turn.movePrompt(player);
        tally = Turn.inputMove(move, availableSpaces, board, tally, player);
        return tally;
    }

}
