package gk.practic.thread.deadlock;

public class PaperPenDeadlock {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper p = new Paper();

        Thread t1 = new Thread(new Task1(pen, p));
        Thread t2 = new Thread(new Task2(pen, p));
        t1.start();
        t2.start();
    }
}
