package com.company.thread.ctp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/10
 */
public class factory{
    Map<Integer,String> fac = new HashMap<>(3);
    Random random = new Random();
    {
        fac.put(1,"糖果");
        fac.put(2,"面包");
        fac.put(0,"可乐");
    }
    static int c;
    public void thingFactory(List<String> mark, Condition useCon, Lock lock){
        lock.lock();
        if (mark.size()>0){
            try {
                useCon.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String s = fac.get(random.nextInt(3));
        mark.add(s);
        System.out.println("生产了--"+s);
        c++;
        lock.unlock();
    }
}
