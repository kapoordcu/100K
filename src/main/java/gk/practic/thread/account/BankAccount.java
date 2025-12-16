package gk.practic.thread.account;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawMoney(int amt) throws InterruptedException {
        System.out.println( Thread.currentThread().getName() + " attempting to withdraw amount: " + amt);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(amt > this.balance) {
                    System.out.println("Insufficient Balance retrieved by : " + Thread.currentThread().getName());
                } else {
                    try {
                        Thread.sleep(3000);
                        this.balance -= amt;
                        System.out.println("Amount: " + amt + " is withdrawn by T:" + Thread.currentThread().getName());
                    } catch (Exception ex) {

                    } finally {
                        lock.unlock();
                    }
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not aquire the lock, will try again");
            }
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex);
        }

    }
}
