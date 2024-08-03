import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] board = Grid.initFrame();
        Space[] spaces = Space.initSpaces(); // Use the static initSpaces method from Space class
        Scanner input = new Scanner(System.in);
        String move;
        int tally = 0;
        String player = " ";

        // initial printing setup
        Grid.printBoard(board);
        System.out.print("\nAvailable spaces: ");
        for (int i = 0; i < spaces.length; i++) {
            System.out.printf("%s ", spaces[i].display);
        }
        System.out.println();

        // start 2 player loop
        while (tally <= spaces.length && (!Turn.winCheck(board))) {   // play until no spaces or a winner
            if (tally % 2 == 0) {
                player = "X";
            } else {
                player = "O";
            }

            // move
            System.out.printf("\nPlayer %s: What's your move? \n", player);
            move = input.nextLine();
            move = move.toUpperCase();

            tally = Turn.inputMove(move, spaces, board, tally, player);  // whose move it is
            if (tally < 0) {
                break;
            }
        }
    }
}
