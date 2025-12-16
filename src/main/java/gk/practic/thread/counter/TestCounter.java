package gk.practic.thread.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ThreadClass t1 = new ThreadClass(counter);
        ThreadClass t2 = new ThreadClass(counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        System.out.println(counter.getCount());
    }
}
