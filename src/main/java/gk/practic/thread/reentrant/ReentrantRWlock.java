package gk.practic.thread.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantRWlock {
    private int count = 0;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public void increment() {
        try {
            writeLock.lock();
            count++;
        } finally {
            writeLock.unlock();
        }
    }
    public int getCount() {
        try {
            readLock.lock();
            return count;
        } finally {
            readLock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantRWlock reentrantRWlock = new ReentrantRWlock();


        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Counter Incremented");
                    reentrantRWlock.increment();
                }
            }
        };

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Counter Read");
                    System.out.println(reentrantRWlock.getCount());
                }
            }
        };

        Thread write = new Thread(writeTask);
        Thread r1 = new Thread(readTask);
        Thread r2 = new Thread(readTask);

        write.start();
        r1.start();
        r2.start();

        write.join();
        r1.join();
        r2.join();
        System.out.println("Final:" + reentrantRWlock.count);
    }
}
