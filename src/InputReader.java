import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jakub Brindza a Viliam Mihalik on 6.2.2016.
 */
public class InputReader {
    public List<String> lines;
    public int numberOfRows;
    public int numberOfColumns;
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
        lines.remove(0); //remove first numbers
    }

    public boolean getCell(int row, int column){
        Character character = lines.get(row).charAt(column);

        if (row >= numberOfRows || column >= numberOfColumns || row < 0 || column < 0){
            throw new IndexOutOfBoundsException();
        }

        if (character.equals("#".charAt(0))){
            return true;
        }else{
            return false;
        }
    }
}
