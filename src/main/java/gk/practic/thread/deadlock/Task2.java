package gk.practic.thread.deadlock;

public class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }


    @Override
    public void run() {
        synchronized (pen) {
            paper.writeOnPaperWithPen(pen);
        }

    }
}
