public class Warehouse{

    public int x;
    public int y;
    public int[] avaliableProducts;

    public Warehouse(int x, int y, int productsNumber){
        this.x = x;
        this.y = y;

        avaliableProducts = new int[productsNumber];
    }

    public void setProductCount(int index, int count){

        avaliableProducts[index] = count;
    }



}