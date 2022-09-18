package producerconsumersemaphore;

public class Consumer implements Runnable {

    private MyQueue myQueue;

   public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    public void run() {
        while (true) {
            // consumer get items
            myQueue.get();
            try {
                Thread.sleep(3900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
