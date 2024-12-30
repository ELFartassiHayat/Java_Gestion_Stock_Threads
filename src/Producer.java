class Producer extends Thread {
    int id;
    int numOfProducts;

    public Producer(int id){
        this.id = id;
    }

    public void produce() {
        synchronized (Stock.stock) {
            try {
                while (Stock.getStockSize() == Stock.MAX_CAPACITY) {
                    System.out.println("Stock reached maximum capacity. P" + id + " is waiting...");
                    Stock.stock.wait();
                }

                boolean added = Stock.stock.add(new Product(numOfProducts++));
                System.out.println("Produced by P" + id + ": Stock size = " + Stock.getStockSize());

                Stock.stock.notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer " + id + " interrupted.");
            }
        }
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        boolean quit = false;
        while(!quit){
            produce();
        }
    }
}