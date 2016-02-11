/**
 * Created by Viliam Mihalik and Jakub Brindza on 11.2.2016.
 */
public class Main {

    public static Output output;
    public static InputReader input;

    public static void main(String[] args) {

        input = new InputReader("redundancy.in");
        output = new Output();
        int dronID = 0;
        for (Dron firstDron : input.drons) {

            label : for(int i = 0; i < input.orders.size(); i++ ){
                Order order = input.orders.get(i);
                if(!order.done){
                    for (int j = 0; j < order.products.length; j++){
                        if (order.products[j] != 0){
                            Warehouse house;
                            int b;
                            label2 : for(b = 0; b < input.warehouses.size(); b++){
                                house = input.warehouses.get(b);
                                for (int a = 0; a < house.avaliableProducts.length; a++){
                                    if(j == a){
                                        if (house.avaliableProducts[a] != 0){
                                            break label2;
                                        }
                                    }
                                }
                            }
//                            b--;

                            int oneWeight = input.products.get(j).weight;
//                                int totalWeight = order.products[j] * oneWeight;
//                                if (input.maxPayload >= oneWeight){
//
//                                }
                            Warehouse house2 = input.warehouses.get(b);
                            int t = getDistance(firstDron.positionX, firstDron.positionY, house2.x, house2.y);
                            int t2 = getDistance(house2.x, house2.y, order.x, order.y);
                            if (firstDron.takenTurns + t+t2+2  <= input.numberOfTurns){
                                output.loadProduct(dronID, 1, j, b);
                                output.deliverProduct(dronID, i, 1, j);
                                firstDron.takenTurns += t+t2+2;
                                firstDron.positionX = order.x;
                                firstDron.positionY = order.y;
                                house2.avaliableProducts[j]--;
                                order.products[j]--;
                            }
                            else{
                                break label;
                            }

                        }
                    }
                }
            }
            dronID++;

        }

        output.generateOutput("redundancy.out");
    }

    public static int getDistance(int firstX, int firstY, int secondX, int secondY){
        double deltaX = firstX - secondX;
        double deltaY = firstY - secondY;
        double result = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        return (int)Math.ceil(result);
    }

}
