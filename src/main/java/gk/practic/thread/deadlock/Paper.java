package gk.practic.thread.deadlock;

public class Paper {
    public synchronized void writeOnPaperWithPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " : is holding Paper lock and expecting:" + pen);
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " : is finishing with: " + this);
    }
}
