package multithread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 创建固定大小的线程池。
 *
 * @author lizhifu
 * @date 2016/11/28 18:34
 */
public class FixedThreadExecutorTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        IntStream.range(0, 6).forEach(i -> executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                String threadName = Thread.currentThread().getName();
                System.out.println("finished: " + threadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        try {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }
    }
}

