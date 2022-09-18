package producerconsumersemaphore;

import java.util.Random;

public class Producer implements Runnable {

    private MyQueue myQueue;

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    public void run() {
        while (true) {
            Random random = new Random();
            int data = random.nextInt(100);
            
            myQueue.put(data);
            try {
                Thread.sleep(1400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
