import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    public List<Warehouse> warehouses;
    public List<Product> products;
    public List<Order> orders;

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

        s = new Scanner(lines.get(1));
        int len = s.nextInt();

        products = new ArrayList<>();

        s = new Scanner(lines.get(2));
        for (int i = 0; i < len; i++){
            products.add(new Product(s.nextInt()));
        }

        s = new Scanner(lines.get(3));
        len = s.nextInt();

        warehouses = new ArrayList<>();
        int index = 4;
        for (int j = 0; j < len; j++){
            s = new Scanner(lines.get(index));
            warehouses.add(new Warehouse(s.nextInt(), s.nextInt(), products.size()));
            index = index+2;
        }

        index = 5;
        for (int j = 0; j < len; j++){
            s = new Scanner(lines.get(index));
            for (int i = 0; i < products.size(); i++){
                warehouses.get(j).setProductCount(i, s.nextInt());
            }
            index = index + 2;
        }

        index--;
        s = new Scanner(lines.get(index));

        int numberOfOrders = s.nextInt();
        s = new Scanner(lines.get(++index));

        orders = new ArrayList<>();
        for (int i = 0; i < numberOfOrders; i++){
            orders.add(new Order(s.nextInt(), s.nextInt(), products.size()));
            s = new Scanner(lines.get(++index));
            for (int j = 0; j < s.nextInt(); j++){
                orders.get(i).increaseOrder(s.nextInt());
            }
        }

    }
}

