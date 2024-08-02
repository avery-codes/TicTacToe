public class Grid {

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
    public static String[][] initFrame() {
        int GRID_SIZE = 6;
        String[][] grid = new String[GRID_SIZE][GRID_SIZE];

        // initializing cells as " "
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = " ";
            }
        }

        // labeling game spaces
        // columns
        grid[0][1] = "1";
        grid[0][3] = "2";
        grid[0][5] = "3";
        // rows
        grid[1][0] = "A";
        grid[3][0] = "B";
        grid[5][0] = "C";

        // formatting grid structure spaces
        for (int j = 1; j < GRID_SIZE; j++) {
            if (j % 2 == 0) {
                grid[2][j] = "+";
                grid[4][j] = "+";
            } else {
                grid[2][j] = "-";
                grid[4][j] = "-";
            }
        }
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 1; j < GRID_SIZE; j++) {
                if (i % 2 == 1 && j % 2 == 0) {
                    grid[i][j] = "|";
                }
            }
        }
        return grid;
    }


    public static void printBoard(String[][] board){
        for (int i = 0; i <= 5; i++) {
            System.out.print("\n");
            for (int j = 0; j <=5; j++) {
                System.out.print(board[i][j]);
                System.out.print("\t");
            }
        }
    }


    public static void printAvailable(Main.Space[] availableSpaces) {
        System.out.print("\nAvailable spaces: ");
        for (int j = 0; j < availableSpaces.length; j++) {
            if (availableSpaces[j].playable) {
                System.out.printf("%s ", availableSpaces[j].display);
            }
        }
    }
}