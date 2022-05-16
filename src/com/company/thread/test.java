package com.company.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/8
 */
class test {
    public static void main(String[] args) throws InterruptedException {
        Train train = new Train();
        Train train2 = new Train();
        train.start();
        train2.start();
    }
}
