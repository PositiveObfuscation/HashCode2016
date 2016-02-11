import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.File;

/**
 * Created by Viliam Mihalik and Jakub Brindza on 6.2.2016.
 */
public class InputReader {
    public List<String> lines;
    public int numberOfRows;
    public int numberOfColumns;
    public int numberOfDrones;
    public int numberOfTurns;
    public int maxPayload;
    public Path file;

    public InputReader(String in) {
        file = Paths.get(in);
        readInput();
    }

    public void readInput(){
        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner s = new Scanner(lines.get(0));
        numberOfRows  = s.nextInt();
        numberOfColumns  = s.nextInt();
        numberOfDrones = s.nextInt();
        numberOfTurns = s.nextInt();
        maxPayload = s.nextInt();

        Scanner s1 = new Scanner(lines.get(1));
        int[] productWeights = int[s1.nextInt()];


        Scanner s2 = new Scanner(lines.get(2));
        for (int i = 0; i < productWeights.length; i++){
            productWeights[i] = s2.nextInt();
        }



    }
}

public class Warehouse{

    public int x;
    public int y;

    public Warehouse(int x, int y){
        this.x = x;
        this.y = y;
    }

}
