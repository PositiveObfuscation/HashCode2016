
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Viliam Mihalik and Jakub Brindza on 6.2.2016.
 */
public class Output {
    public List<String> lines;

    public Output() {
        lines = new ArrayList<>();
    }

    public void generateOutput(String fileName){
        lines.add(0, "" + lines.size()); //add number of painting commands
        Path file = Paths.get(fileName);

        try {
            Files.write(file, lines, Charset.forName("US-ASCII"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProduct(int dronID, int numberOfProducts, int productID, int warehouseID){
        lines.add(dronID + " L " + numberOfProducts + " " + productID + " " + warehouseID );
    }

    public void deliverProduct(int dronID, int customerID, int numberOfProducts, int productID){
        lines.add(dronID + " L " + customerID + " " + numberOfProducts + " " + productID );
    }

    public void unloadProduct(int dronID, int numberOfProducts, int productID, int warehouseID){
        lines.add(dronID + " U " + numberOfProducts + " " + productID + " " + warehouseID );
    }

    public void waitDron(int dronID, int numberOfTurns){
        lines.add(dronID + " U " + numberOfTurns);
    }
}
