package com.company.thread.ctp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/10
 */
public class mark {
    final List<String> mark = new ArrayList<>();
    Lock lock = new ReentrantLock();
    public void open(){
        Condition facCon = lock.newCondition();
        Condition useCon = lock.newCondition();
        factory fac = new factory();
        use use = new use();
        Thread facRunnable = new Thread(()->{
            for (int i = 0; i < 20; i++) {
                fac.thingFactory(mark,useCon,lock);
            }
        });
        Thread userRunnable = new Thread(()->{
            for (int i = 0; i < 20; i++) {
                use.thingFactory(mark,useCon,lock);
            }
        });
        userRunnable.start();
        facRunnable.start();
    }
    public static void main(String[] args) {
        mark mark = new mark();
        mark.open();
    }

}
