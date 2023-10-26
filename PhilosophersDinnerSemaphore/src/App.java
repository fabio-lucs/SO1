package src;

import java.util.concurrent.Semaphore;

public class App {
    private static final int N = 5; // Número de filósofos

    public static void main(String[] args) {
        Semaphore[] fork = new Semaphore[N];
        Philosopher[] philosopher = new Philosopher[N];

        for (int i = 0; i < N; i++) {
            fork[i] = new Semaphore(1);

        }

        for (int i = 0; i < N; i++) {
            philosopher[i] = new Philosopher(i, fork[i], fork[(i + 1) % N]);
            new Thread(philosopher[i]).start();
        }

        // Aguarda um tempo ou condição para encerrar o programa
        try {
            Thread.sleep(10000); // Espera 10 segundos (você pode ajustar esse valor)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Define a condição de parada
        for (Philosopher p : philosopher) {
            p.stopPhilosopher();
        }
    }

}
