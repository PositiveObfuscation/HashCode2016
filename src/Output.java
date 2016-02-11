
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

    public Output(InputReader in) {
        lines = new ArrayList<>();
        lines = in.lines;
    }

    public void generateOutput(String fileName){
        Path file = Paths.get(fileName);

        try {
            Files.write(file, lines, Charset.forName("US-ASCII"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
