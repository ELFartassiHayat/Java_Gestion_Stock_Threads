public class Product {
    String name;
    int id;

    public Product(String name){
        this.name = name;
    }

    public Product(){}

    public Product(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Product-"+id;
    }
}
