package multithread.executor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 *
 * @author lizhifu
 * @date 2016/11/28 18:45
 */
public class ScheduledThreadExecutorTest {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate( () -> System.out.println(System.currentTimeMillis()), 1000, 2000, TimeUnit.MILLISECONDS);

    }
}

