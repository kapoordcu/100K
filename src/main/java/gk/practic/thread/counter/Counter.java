package gk.practic.thread.counter;

public class Counter {
    public int count = 0;

    public void increment() {
        synchronized(this) {
            count++;
        }
    }

    public int getCount() {
       return count;
    }
}
