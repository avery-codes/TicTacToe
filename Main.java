import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] board = Grid.initFrame();
        Space[] spaces = initSpaces();
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


    public static class Space {
        int coordX;
        int coordY;
        String display;
        boolean playable;

        public Space(int coordX, int coordY, String display, boolean playable) {
            this.coordX = coordX;
            this.coordY = coordY;
            this.display = display;
            this.playable = playable;
        }
    }

    public static Space[] initSpaces() {
        Space[] spaces = new Space[9];

        spaces[0] = new Space(1, 1, "A1", true);
        spaces[1] = new Space(1, 3, "A2", true);
        spaces[2] = new Space(1, 5, "A3", true);
        spaces[3] = new Space(3, 1, "B1", true);
        spaces[4] = new Space(3, 3, "B2", true);
        spaces[5] = new Space(3, 5, "B3", true);
        spaces[6] = new Space(5, 1, "C1", true);
        spaces[7] = new Space(5, 3, "C2", true);
        spaces[8] = new Space(5, 5, "C3", true);

        return spaces;
    }
}