public class Warehouse{

    public int x;
    public int y;
    public int[] products;

    public Warehouse(int x, int y, int productsNumber){
        this.x = x;
        this.y = y;

        products = new int[productsNumber];
    }

    public void setProductCount(int index, int count){
        products[index] = count;
    }

}