public class Order {

    public int x;
    public int y;
    public int[] products;

    public Order(int x, int y, int productsNumber){
        this.x = x;
        this.y = y;
        products = new int[productsNumber];
    }

    public void increaseOrder(int index){
        products[index] += 1;
    }

}