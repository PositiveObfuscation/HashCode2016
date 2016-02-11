public class Order {

    public int x;
    public int y;
    public int[] products;
    public boolean done;

    public Order(int x, int y, int productsNumber){
        this.x = x;
        this.y = y;
        done = false;
        products = new int[productsNumber];
    }

    public void increaseOrder(int index){
        products[index] += 1;
    }

}