package src;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private Random number = new Random();

    private int id;
    private Semaphore left_fork;
    private Semaphore right_fork;

    public Philosopher(int id, Semaphore left_fork, Semaphore right_fork) {
        this.id = id;
        this.left_fork = left_fork;
        this.right_fork = right_fork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                takeLeftFork();
                takeRightFork();
                eat();
                returnFork();

            }
        } catch (Exception e) {
            System.out.println("The philosopher " + this.id + " was interrupted.");
        }
    }

    private void think() throws InterruptedException {
        System.out.println("The philosopher " + this.id + " is thinking.\n");
        Thread.sleep(number.nextInt(1000));

    }

    private void takeLeftFork() throws InterruptedException {
        if (this.left_fork.availablePermits() == 0) {
            System.out.println("the philosopher " + this.id + " is waiting for the left fork.\n");
        }
        this.left_fork.acquire();
        System.out.println("the philosopher " + this.id + " is holding for the left fork.\n");

    }

    private void takeRightFork() throws InterruptedException {
        if (this.right_fork.availablePermits() == 0) {
            System.out.println("the philosopher " + this.id + " is waiting for the right fork.\n");
        }
        this.right_fork.acquire();
        System.out.println("the philosopher " + this.id + " is holding for the right fork.\n");

    }

    private void eat() throws InterruptedException {
        System.out.println("The philosopher " + this.id + " is eating.\n");
        Thread.sleep(number.nextInt(1000));
    }

    private void returnFork() throws InterruptedException {
        this.left_fork.release();
        this.right_fork.release();
        System.out.println("The philosopher " + this.id + " dropped the forks.\n");
    }

}
