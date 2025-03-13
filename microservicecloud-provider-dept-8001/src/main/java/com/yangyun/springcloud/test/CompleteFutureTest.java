package com.yangyun.springcloud.test;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @author yangyun
 * @project springcloud
 * @description:
 * @date 2024-08-22 10:07
 */
public class CompleteFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {


        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        BusinessSummaryDataReportVo vo = new BusinessSummaryDataReportVo();

        long start = System.currentTimeMillis();
        CompletableFuture<BusinessSummaryDataReportVo> supplyAsync = CompletableFuture.supplyAsync(() -> {
            long supplyAsyncStart = System.currentTimeMillis();
            vo.setA("a");
            vo.setB("b");
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("supplyAsync1");
            long supplyAsyncEnd = System.currentTimeMillis();
            System.out.println(supplyAsyncEnd - supplyAsyncStart);
            return null;
        }, threadPool);

        BusinessSummaryDataReportVo businessSummaryDataReportVo = supplyAsync.get(1000, TimeUnit.MILLISECONDS);
        System.out.println("------------");

        CompletableFuture<BusinessSummaryDataReportVo> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            long supplyAsync2Start = System.currentTimeMillis();
            vo.setC("c");
            vo.setD("d");
            try {
                Thread.sleep(6 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("supplyAsync2");
            long supplyAsync2End = System.currentTimeMillis();
            System.out.println(supplyAsync2End - supplyAsync2Start);
            return null;
        }, threadPool);


        long end = System.currentTimeMillis();
        System.out.println("main" + (end - start));
        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.allOf(supplyAsync, supplyAsync2);
        voidCompletableFuture1.get();

        System.out.println("================");
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(supplyAsync);
        Void unused = voidCompletableFuture.get(60, TimeUnit.SECONDS);
        System.out.println(vo);
        threadPool.shutdown();
    }

}
