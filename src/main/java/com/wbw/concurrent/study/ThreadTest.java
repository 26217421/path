package com.wbw.concurrent.study;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * 螺纹试验
 *
 * @author wbw
 * @since 2022-5-20 14:47
 */
@Slf4j
public class ThreadTest {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }
    class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            log.info("test log");
            return 2;
        }
    }
    @Test
    public void testComCompletableFuture() {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 1");
            return "step1 result";
        }, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 2");
            return "step2 result";
        });
        cf1.thenCombine(cf2, (result1, result2) -> {
            System.out.println(result1 + " , " + result2);
            System.out.println("执行step 3");
            return "step3 result";
        }).thenAccept(System.out::println);
    }
    /**
     * 回调地狱
     */
    @Test
    public void testCallbackHell() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        ListeningExecutorService guavaExecutor = MoreExecutors.listeningDecorator(executor);
        ListenableFuture<String> future1 = guavaExecutor.submit(() -> {
            //step 1
            System.out.println("执行step 1");
            return "step1 result";
        });
        ListenableFuture<String> future2 = guavaExecutor.submit(() -> {
            //step 2
            System.out.println("执行step 2");
            return "step2 result";
        });
        ListenableFuture<List<String>> future1And2 = Futures.allAsList(future1, future2);
        Futures.addCallback(future1And2, new FutureCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> result) {
                System.out.println(result);
                ListenableFuture<String> future3 = guavaExecutor.submit(() -> {
                    System.out.println("执行step 3");
                    return "step3 result";
                });
                Futures.addCallback(future3, new FutureCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        System.out.println(result);
                    }
                    @Override
                    public void onFailure(Throwable t) {
                    }
                }, guavaExecutor);
            }

            @Override
            public void onFailure(Throwable t) {
            }}, guavaExecutor);
    }

    @Test
    public void testCallable() throws ExecutionException, InterruptedException {
        BlockingQueue<Runnable> queue = new SynchronousQueue<>();
        ThreadFactory nameThreadFactory = Thread::new;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
                0, TimeUnit.MILLISECONDS, queue, nameThreadFactory);
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        // 注意调用get方法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使用可以设置超时时间的重载get方法。
        System.out.println(result.get());
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        executor.submit(futureTask);
        System.out.println(futureTask.get());
        executor.shutdown();
    }
    @Test
    public void testRunner() {
        new Thread(()->
            System.out.println("runner")).start();
    }
    @Test
    public void testThread(){
        new MyThread().start();
    }
}
