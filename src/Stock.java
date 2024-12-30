import java.util.Stack;

class Stock {
    public static final Stack<Product> stock = new Stack<>();
    public static final int MAX_CAPACITY = 10;

    public static boolean add(Product product) {
        return stock.add(product);
    }

    public static Product remove() {
        return stock.pop();
    }

    public static int getStockSize() {
        return stock.size();
    }
}