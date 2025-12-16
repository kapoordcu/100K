package gk.practic.thread.account;

public class TestBankAccount {


    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(100) ;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    account.withdrawMoney(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Remaioning balance after all processes: " + account.getBalance());
    }
}
