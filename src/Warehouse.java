public class Warehouse{

    public static int x;
    public static int y;
    public static int[] products;

    public Warehouse(int x, int y, int productsNumber){
        this.x = x;
        this.y = y;

        products = new int[productsNumber];
    }

    public static void setProductCount(int index, int count){
        products[index] = count;
    }

}