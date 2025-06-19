package core.durga.concurrency;

/**
 * @author khanh
 * @date 6/19/2025
 *  Inter-Thread Communication
 */
public class InterThread {

    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        b.start();
        synchronized (b) {
            System.out.println("STEP_1: Main thread started trying to call wait() method");
            b.wait();
            System.out.print("STEP_4: Main thread finished got notification, Total:" + b.total);
        }

    }
}

class ThreadB extends Thread {
    int total = 0;

    public void run() {
        System.out.println("STEP_2: ThreadB started Calculation."); // step 2
        synchronized (this) {
            for (int i = 0; i <= 100; i++) {
                total += i;
            }
            this.notify();
            System.out.println("STEP_3: Child thread trying to give notification.");
        }
    }

}
