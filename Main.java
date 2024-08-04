import java.util.Scanner;


public class Main {
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        String[][] board = Grid.initFrame();
        Space[] availableSpaces = Space.initSpaces();
        int tally = 0;
        String player;
        String playersChoice;

        // opening player count prompt
        System.out.println("Welcome to TicTacToe. Up to two players can play at a time.");
        System.out.println("One or two players?");
        playersChoice = in.nextLine();


        if (playersChoice.equals("1") || playersChoice.equals("one") || playersChoice.equals("One")) {
            // autoplayer
            Autoplayer ap = new Autoplayer();
            int playOrder = 0;  // defaults to human player as first
            String player1 = "X";
            String player2 = "O";

            System.out.println("Starting Autoplayer");

            if (ap.flip()){         // all elements initialized as heads, this switches it all to tails
                playOrder = 1;
                player1 = "O";
                player2 = "X";
            }

            if (playOrder == 0){        // informing human which player they are
                System.out.println("You will play as X\n");
            } else {
                System.out.println("You will play as O\n");
            }

            // printing board and spaces to begin game
            Grid.printBoard(board);
            Grid.printAvailable(availableSpaces);

            // 1 player gameplay loop
            while (tally <= availableSpaces.length) {  // play until no availableSpaces or a winner
                // human player
                if (tally % 2 == playOrder) {   // 0 or 1
                    player = player1;
                    tally = Turn.humanPlayer(player, tally, availableSpaces, board);
                // autoplayer
                } else {
                    player = player2;
                    tally = ap.autoPlayer(player, tally, availableSpaces, board);
                }

                // checking if the game has been won
                if (Turn.winAnnounce(board, player, tally)){
                    break;
                }
                else {
                    Grid.printAvailable(availableSpaces);
                }
            }


        } else {   // 2 player
            System.out.println("Starting two player game:");
            // initial printing setup
            Grid.printBoard(board);
            Grid.printAvailable(availableSpaces);

            // 2 player gameplay loop
            while (tally <= availableSpaces.length){  // play until no availableSpaces or a winner
                if (tally % 2 == 0) {
                    player = "X";
                    tally = Turn.humanPlayer(player, tally, availableSpaces, board);
                } else {
                    player = "O";
                    tally = Turn.humanPlayer(player, tally, availableSpaces, board);
                }

                // checking if the game has been won
                if (Turn.winAnnounce(board, player, tally)){
                    break;
                }
                else {
                    Grid.printAvailable(availableSpaces);
                }
            }
        }

        in.close();
    }
}