
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jakub Brindza a Viliam Mihalik on 6.2.2016.
 */
public class Output {
    public List<String> lines;

    public Output(InputReader in) {
        lines = new ArrayList<>();
    }

    public void paintLine(int row1, int row2, int column1, int column2){
        lines.add("PAINT_LINE " + row1 + " " + row2 + " " + column1 + " " + column2);

    }
    public void paintSquare(int row, int column, int s){
        lines.add("PAINT_SQUARE " + row + " " + column + " " + s);
    }
    public void ereaseCell(int row, int column){
        lines.add("ERASE_CELL " + row + " " + column);
    }
    public void generateOutput(String fileName){
        System.out.println("Score(number of commands): " + lines.size());
        lines.add(0, "" + lines.size()); //add number of painting commands
        Path file = Paths.get(fileName);
        //test if file exist
        if (file.toFile().isFile()){
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("The filename for output already exists. Do you want to overwrite it? y/n");
            String answer = reader.nextLine();
            if(!answer.equalsIgnoreCase("y")){
                return;
            }
        }

        try {
            Files.write(file, lines, Charset.forName("US-ASCII"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfCommands(){
        return lines.size();
    }

    public void resetOutput(){
        lines = new ArrayList<>();
    }
}
