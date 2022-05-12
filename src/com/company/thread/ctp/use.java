package com.company.thread.ctp;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/10
 */
public class use {

    static int c;
    public void thingFactory(List<String> mark, Condition useCon, Lock lock){
        lock.lock();
        if (mark.size()<1){
            try {
                useCon.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s = mark.get(0);
        System.out.println("消费了--"+s);
        mark.remove(s);
        c++;
        lock.unlock();
    }
}
