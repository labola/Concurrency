package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main1 {
    private static int POOL = 1_000_000;
    private static int POOLLIST = 1_000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        long before = System.currentTimeMillis();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < POOL; i++) {

                    sum += i;
                }
                System.out.println("Sum = " + sum);
                countDownLatch.countDown();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                long result = 0;

                for (int i = 0; i < POOL; i++) {
                    if (i % 7 == 0) {
                        result += i;
                    }
                }
                System.out.println("Sum / 7 = " + result);
                countDownLatch.countDown();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int result = 0;
                List<Integer> arr = new ArrayList<>(POOLLIST);
                for (int i = 0; i < POOLLIST; i++) {
                    Random rnd = new Random();
                    arr.add(rnd.nextInt(1000));
                }
                for (int i = 0; i < POOLLIST; i++) {
                    if (arr.get(i) % 2 == 0) {
                        result += arr.get(i);
                    }
                }
                System.out.println("Sum arr = " + result);
                countDownLatch.countDown();
            }
        });
        executorService.shutdown();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long after = System.currentTimeMillis();
        System.out.println(after-before);
    }
}
