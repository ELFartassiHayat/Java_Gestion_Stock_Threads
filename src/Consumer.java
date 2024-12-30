class Consumer extends Thread {
    int id;

    public Consumer(int id){
        this.id = id;
    }

    public void consume() {
        synchronized (Stock.stock){
            try {
                while (Stock.getStockSize() == 0) {
                    System.out.println("Stock is empty. C" + id + " is waiting...");
                    Stock.stock.wait();
                }

                Product item = Stock.remove();
                System.out.println("Consumed by C" + id + ": " + item + ", Stock size = " + Stock.getStockSize());

                Stock.stock.notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer " + id + " interrupted.");
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
        while (!quit){
            consume();
        }
    }
}