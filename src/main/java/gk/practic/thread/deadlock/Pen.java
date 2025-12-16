package gk.practic.thread.deadlock;

public class Pen {
    public synchronized void writeWithPenOnPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " : is holding Pen lock and expecting:" + paper);
        paper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " : is finishing with pen" + this);
    }
}
