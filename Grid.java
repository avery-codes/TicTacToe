public class Grid {
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
