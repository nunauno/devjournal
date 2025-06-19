package core.durga.concurrency;

import java.util.concurrent.*;

/**
 * @author khanh
 * @date 6/19/2025
 * Inter-Thread Communication using ExecutorService + Future
 */
public class InterThreadExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        System.out.println("STEP_1: Main thread submits the task to executor");

        Future<Integer> future = executor.submit(() -> {
            System.out.println("STEP_2: Child thread (executor) started calculation.");
            int total = 0;
            for (int i = 0; i <= 100; i++) {
                total += i;
            }
            System.out.println("STEP_3: Child thread finished and returns the result.");
            return total;
        });

        System.out.println("STEP_4: Main thread waiting for result using future.get()");

        Integer result = future.get(); // waits until the result is ready

        System.out.println("STEP_5: Main thread got result: Total = " + result);

        executor.shutdown(); // always shutdown your executors
    }
}
