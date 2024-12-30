import java.util.ArrayList;
import java.util.Stack;

public class StockManagement {
    public static void main(String[] args) {

        int PRODUCER_MAX = args.length == 2 ? Integer.parseInt(args[0]) : 1;
        int CONSUMER_MAX = args.length == 2 ? Integer.parseInt(args[1]) : 1;

        ArrayList<Producer> producers = new ArrayList<>();
        ArrayList<Consumer> consumers = new ArrayList<>();

        for (int i = 0; i < PRODUCER_MAX; i++){
            producers.add(new Producer(i));
        }

        for (int i = 0; i < CONSUMER_MAX; i++){
            consumers.add(new Consumer(i));
        }

        for (var producer : producers){
            producer.start();
        }

        for (var consumer : consumers){
            consumer.start();
        }
    }
}
