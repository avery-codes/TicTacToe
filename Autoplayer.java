import java.util.Random;


public class Autoplayer {
    Random random = new Random();


    public boolean flip(){
        return random.nextBoolean();
    }


    public String autoMove(Space[] availableSpaces){
        int size;
        int moveIndex;

        size = availableSpaces.length;
        moveIndex = random.nextInt(size)-1;

        return availableSpaces[moveIndex].display;
    }


    public int autoPlayer(String player, int tally, Space[] availableSpaces, String[][] board)
            throws InterruptedException{
        String move = autoMove(availableSpaces);
        System.out.printf("\n(Auto)Player %s move: %s\n", player, move);
        Thread.sleep(750);
        tally = Turn.inputMove(move, availableSpaces, board, tally, player);
        return tally;
    }

}