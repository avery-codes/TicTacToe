import java.util.Random;
public class Autoplayer {


    public String autoMove(Space[] availableSpaces){
        int size;
        int moveIndex;
        Random random = new Random();

        size = availableSpaces.length;
        moveIndex = random.nextInt(size);

        return availableSpaces[moveIndex].display;
    }
}