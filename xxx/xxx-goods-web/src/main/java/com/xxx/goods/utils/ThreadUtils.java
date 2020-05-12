package com.xxx.goods.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 线程工具类
 * @author Renda Zhang
 * @create 2020-05-12 14:16
 */
public class ThreadUtils {

    private static final ExecutorService es = Executors.newFixedThreadPool(10);

    public static void execute(Runnable runnable) {
        es.submit(runnable);
    }
}
