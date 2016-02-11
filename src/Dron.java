import java.awt.*;

/**
 * Created by Jakub Brindza a Viliam Mihalik on 11.2.2016.
 */
public class Dron {

    int positionX;
    int positionY;


    public Dron(int positionX, int positionY) {
        this.positionY = positionY;
        this.positionX = positionX;
    }

    public int getDistance(int distanceX, int distanceY){
        double deltaX = distanceX - positionX;
        double deltaY = distanceY - positionY;
        double result = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        return (int)Math.ceil(result);
    }
}
