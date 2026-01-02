package gk.practic.thread.executors;

public class BeforeExecutorExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            threads[i-1] = new Thread (
                () -> {
                    long result = factorial(finalI);
                    System.out.println(result);
                }
            );
            threads[i-1].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Time in ms:" +  (System.currentTimeMillis() - start));
    }

    public static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1l;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return result;
    }
}
