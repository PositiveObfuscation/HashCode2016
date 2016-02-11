public class Product{
        public static int weight;

        public Product(int weight){
            this.weight = weight;
        }

        public static int getWeight(){
            return weight;
        }

        public void setWeight(int w){
            weight = w;
        }
}