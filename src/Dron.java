import java.awt.*;

/**
 * Created by Jakub Brindza a Viliam Mihalik on 11.2.2016.
 */
public class Dron {

    public int positionX;
    public int positionY;
    public int takenTurns;


    public Dron(int positionX, int positionY) {
        this.positionY = positionY;
        this.positionX = positionX;
        this.takenTurns = 0;
    }

    public int getDistance(int distanceX, int distanceY){
        double deltaX = distanceX - positionX;
        double deltaY = distanceY - positionY;
        double result = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        return (int)Math.ceil(result);
    }

    public int getTakenTurns() {
        return takenTurns;
    }

    public void setTakenTurns(int takenTurns) {
        this.takenTurns = takenTurns;
    }
}
