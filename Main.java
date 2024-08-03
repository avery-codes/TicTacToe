import java.util.Scanner;

public class Main {
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] board = Grid.initFrame();
        Space[] availableSpaces = Space.initSpaces();
        String move;
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
            System.out.println("Starting Autoplayer");
            // code to play autoplayer

        } else {   // 2 player
            System.out.println("Starting two player game:");
            // initial printing setup
            Grid.printBoard(board);
            Grid.printAvailable(availableSpaces);


            // 2 player loop
            while (tally <= availableSpaces.length){  // play until no availableSpaces or a winner
                if (tally % 2 == 0) {
                    player = "X";
                } else {
                    player = "O";
                }

                move = Turn.movePrompt(player);

                tally = Turn.inputMove(move, availableSpaces, board, tally, player);  // whose move it is

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